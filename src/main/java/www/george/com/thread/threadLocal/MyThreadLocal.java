package www.george.com.thread.threadLocal;

/**
 * @author rouqiu
 *
 */
public class MyThreadLocal {
    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] argv) throws InterruptedException {
        final MyThreadLocal myThreadLocal = new MyThreadLocal();
        myThreadLocal.set();
        System.out.println(myThreadLocal.getLong());
        System.out.println(myThreadLocal.getString());

        Thread thread1 = new Thread(){
            public void run() {
                myThreadLocal.set();
                System.out.println(myThreadLocal.getLong());
                System.out.println(myThreadLocal.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(myThreadLocal.getLong());
        System.out.println(myThreadLocal.getString());
    }

}
