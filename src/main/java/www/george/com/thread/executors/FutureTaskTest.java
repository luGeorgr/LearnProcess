package www.george.com.thread.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    private final ConcurrentHashMap<Object, FutureTask<String>> taskCache = new ConcurrentHashMap<>();
    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            FutureTask<String> futureTask = taskCache.get(taskName);
            if (futureTask == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };

                FutureTask<String> future = new FutureTask<>(task);
                futureTask = taskCache.putIfAbsent(taskName, future);
                futureTask.run();
            }
            return futureTask.get();
        }
    }

    public static void main(final String[] argv) {

    }
}
