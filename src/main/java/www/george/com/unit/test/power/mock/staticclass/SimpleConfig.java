package www.george.com.unit.test.power.mock.staticclass;

import java.util.Properties;

/**
 * @author rouqiu
 *
 */
public class SimpleConfig {
    private static Properties PROPERTIES;

    //https://blog.csdn.net/javazejian/article/details/72828483
    private static synchronized void initialize() {
        if (PROPERTIES == null) {
            PROPERTIES = new Properties();
            try {
                PROPERTIES.load(SimpleConfig.class.getClassLoader().getResourceAsStream("simpleConfig.properties"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getGreeting() {
        initialize();
        return PROPERTIES.getProperty("greeting");
    }

    public static String getTarget() {
        initialize();
        return PROPERTIES.getProperty("target");
    }

}
