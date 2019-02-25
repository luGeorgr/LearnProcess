package www.george.com.jvm;

/**
 * @author rouqiu
 *
 */
public class FinalizeEscapeGc {
    public static FinalizeEscapeGc REFERENCE;
    public static void main(String[] argv) {
        REFERENCE = new FinalizeEscapeGc();
        REFERENCE = null;
        System.gc();
        testAlive(REFERENCE);
        REFERENCE = null;
        System.gc();
        testAlive(REFERENCE);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize now");
        REFERENCE = this;
    }

    public void sayHello() {
        System.out.println("Hello World");
    }

    public static void testAlive(FinalizeEscapeGc finalizeEscapeGc) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (REFERENCE != null) {
            REFERENCE.sayHello();
        } else {
            System.out.println("die");
        }
    }
}
