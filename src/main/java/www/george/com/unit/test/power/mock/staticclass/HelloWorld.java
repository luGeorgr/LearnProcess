package www.george.com.unit.test.power.mock.staticclass;

/**
 * @author rouqiu
 *
 */
public class HelloWorld {
    public String greeting() {
        return SimpleConfig.getGreeting() + " " + SimpleConfig.getTarget();
    }
}
