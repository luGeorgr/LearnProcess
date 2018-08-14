package www.george.com.thread.join;

/**
 * @author rouqiu
 *
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest t1 = new ThreadJoinTest("I");
        ThreadJoinTest t2 = new ThreadJoinTest("You");
        t1.start();

        t1.join();
        t2.start();
    }
}


class ThreadJoinTest extends Thread {
    public ThreadJoinTest(final String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(super.getName());
        }

        try {
            throw new Exception("Hello World");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}