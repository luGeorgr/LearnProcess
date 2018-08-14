package www.george.com.thread.exception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author rouqiu
 *
 */
public class ThreadException {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Callable<String> c1 = new ThreadException.MyCallableThread();
        Future<String> future = pool.submit(c1);



        try {
            System.out.println(future.get());
        } catch (Exception e) {
            System.out.println("error....");
        } finally {
            pool.shutdown();
        }

        Thread t = new Thread(new MyRunnableThread());
        t.setUncaughtExceptionHandler(new MyExceptionHandler());
        t.start();
    }

    public static class MyCallableThread implements Callable<String> {
        public MyCallableThread() {}

        @Override
        public String call() throws Exception {
            int a = 1/0;
            return "abc";
        }
    }

    static class MyRunnableThread implements Runnable {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}

class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(final Thread t, final Throwable e) {
        System.out.println("hello world");
    }
}