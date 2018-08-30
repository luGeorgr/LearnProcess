package www.george.com.thread.debug;

/**
 * @author rouqiu
 *
 */
public class TestDebugThread {

    static public void main(String[] argv) {
        new Thread(()-> {
            while (true) {
                System.out.println(1);
            }
        }).start();
        new Thread(new Run()).start();
        while(true) {

        }
    }
}

class Run implements Runnable {

    @Override
    public void run() {
        System.out.println(2);
    }
}
