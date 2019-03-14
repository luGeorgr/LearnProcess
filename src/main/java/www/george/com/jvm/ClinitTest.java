package www.george.com.jvm;

/**
 * @author rouqiu
 *
 */
public class ClinitTest {
    public static void main(String[] argc) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                DeepLoopClass deepLoopClass = new DeepLoopClass();
                System.out.println(Thread.currentThread().getName() + " end");
            }
        };
        Thread a = new Thread(runnable);
        Thread b = new Thread(runnable);
        a.start();
        b.start();
    }
}

class DeepLoopClass {
    static {
        if (true) {
            System.out.println("begin init DeepLoopClass");
            while (true) {

            }
        }
    }
}
