package www.george.com.designpattern.chainOfResponsibilityPattern;

/**
 * @author rouqiu
 *
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(final int level) {
        this.level = level;
    }

    @Override
    protected void write(final String message) {
        System.out.println("File Logger: " + message);
    }
}
