package www.george.com.designpattern.chainOfResponsibilityPattern;

/**
 * @author rouqiu
 *
 */
public class ConseleLogger extends AbstractLogger {
    public ConseleLogger(final int level) {
        this.level = level;
    }

    @Override
    protected void write(final String message) {
        System.out.println("Standard Console Logger: " + message);
    }
}
