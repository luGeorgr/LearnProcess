package www.george.com.thread.blockQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author rouqiu
 *
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Enter base directory:");
            String directory = in.nextLine();
            System.out.println("Enter key word");
            String keyword = in.nextLine();
            new Thread(()->{
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            for (int i = 1; i <= SEARCH_THREADS; i++) {
                new Thread(()->{
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }

    public static void enumerate(File director) throws InterruptedException {
        File[] files = director.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            } else {
                queue.put(file);
            }
        }
    }

    public static void search(File file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, "utf-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s/n", file.getPath(), lineNumber, line);
                }
            }
        }
    }
}
