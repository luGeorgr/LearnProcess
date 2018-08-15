package www.george.com.designpattern.chainOfResponsibilityPattern;

/**
 * @author rouqiu
 *
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(final int level) {
        this.level = level;
    }

    @Override
    protected void write(final String message) {
        System.out.println("Error Console Logger: " + message);
    }
}

