package www.george.com.thread.synch;

/**
 * @author rouqiu
 *
 */
public class SynchronizedTest {
    public volatile int i = 0;
    public void increase() {
        i++;
    }

    public static void main(String[] argv) {
        final SynchronizedTest synchronizedTest = new SynchronizedTest();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(()-> {
                for (int j = 0; j < 1000; j++) {
                    synchronizedTest.increase();
                }
            });
            t.start();
        }
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(synchronizedTest.i);
    }
}
