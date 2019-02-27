import java.io.File;

/**
 * @author rouqiu
 *
 */
public class Main {
    public static void main(String[] argv) {
        System.out.println(System.currentTimeMillis());
        File file = new File("D://test/test.txt");
        System.out.println(file.lastModified());
    }
}
