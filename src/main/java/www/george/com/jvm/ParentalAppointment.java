package www.george.com.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author rouqiu
 *
 */
public class ParentalAppointment {
    public static void main(String[] argv) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(final String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf('.') + 1) + ".class";
                    InputStream is;
                    is = getClass().getResourceAsStream(fileName);

                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        Object obj = classLoader.loadClass("www.george.com.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }
}
