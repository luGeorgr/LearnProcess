package www.george.com.thread.lock;

import java.util.concurrent.TimeUnit;

public class TreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }

    private static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.sleep(100);
            }
        }
    }
    private static class Waiting implements Runnable {
        @Override
        public void run() {
            synchronized (Waiting.class) {
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.sleep(100);
                }
            }
        }
    }

    private static class SleepUtils {
        public static void sleep(long ms) {
            try {
                TimeUnit.SECONDS.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
