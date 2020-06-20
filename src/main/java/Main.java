import org.codehaus.jackson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

/**
 * @author rouqiu
 *
 */
public class Main implements Runnable {
    public static void main(String[] argv) throws IOException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Main());
    }

    private static String MONITOR_DIRECTOR = "C:\\Users\\admin\\Desktop\\test";
    private final WatchService watchService;
    private final long startTime;
    private final ExecutorService executorService;
    public Main() throws IOException {
        final File file = new File(MONITOR_DIRECTOR);
        if (!file.exists() && !file.mkdir()) {
            throw new IOException("create monitor directory error");
        }
        final Path path = Paths.get(MONITOR_DIRECTOR);
        watchService = FileSystems.getDefault().newWatchService();
        //监听文件的创建任务
        path.register(watchService, ENTRY_CREATE);
        startTime = System.currentTimeMillis();
        executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void run() {
        while (true) {
            final WatchKey key;
            try {
                key = watchService.take();
            } catch (final InterruptedException e) {
                continue;
            }
            final List<String> files = key.pollEvents().stream()
                    .map(WatchEvent::context)
                    .map(Object::toString)
                    .collect(Collectors.toList());
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 10000) {

            }
            System.out.println(files);
            key.reset();
        }
    }

    private class Task implements Callable<String> {
        private String fileName;
        Task(final String fileName) {
            this.fileName = fileName;
        }
        @Override
        public String call() throws Exception {
            System.out.println(fileName);
            throw new IllegalArgumentException();
        }
    }
}
