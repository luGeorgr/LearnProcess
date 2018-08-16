package www.george.com.designpattern.chainOfResponsibilityPattern;

/**
 * @author rouqiu
 *
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int WARN = 2;
    public static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(final int level, final String message) {
        if (this.level <= level) {
            write(message);
            return;
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

}
