package www.george.com.jvm;

/**
 * @author rouqiu
 *
 */
public class AllocationTest {
    public static int _1M = 1024 * 1024;
    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     */
    public static void allocate() {
        byte[] a = new byte[2 * _1M];
        byte[] b = new byte[2 * _1M];
        byte[] c = new byte[4 * _1M]; //观察gc日志发现无溢出
        byte[] d = new byte[2 * _1M];
    }
    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+PrintGCDetails
     */
    public static void testBig() {
        byte[] c = new byte[4 * _1M]; //观察gc日志 发现PretenureSizeThreshold没有起任何作用。 跟收集器有关
    }

    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintGCDetails
     */
    public static void testTenuring() {
        byte[] allocationA, allocationB, allocationC;
        allocationA = new byte[_1M * 2];
        allocationB = new byte[_1M * 3];
        allocationC = new byte[_1M * 3];
        allocationC = null;
        //allocationC = new byte[_1M * 4];
    }

    public static void main(final String[] argv) {
        testTenuring();
    }
}
