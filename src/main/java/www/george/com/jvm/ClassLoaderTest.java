package www.george.com.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author rouqiu
 *
 */
public class ClassLoaderTest {
    public static void main(String[] argv) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(final String name) throws ClassNotFoundException {
                byte[] b;
                try {
                    InputStream is = new FileInputStream(new File
                            ("D:/workspaces/LearnProcess/target/classes/www/george/com/jvm/AllocationTest.class"));
                    b = new byte[is.available()];
                    is.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
                return defineClass("www.george.com.jvm.AllocationTest", b, 0, b.length);
            }
        };
        Object obj = classLoader.loadClass("www.george.com.jvm.AllocationTest.class").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }
}