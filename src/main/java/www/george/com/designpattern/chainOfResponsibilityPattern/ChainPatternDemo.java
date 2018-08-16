package www.george.com.designpattern.chainOfResponsibilityPattern;

/**
 * @author rouqiu
 *
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainLogger() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.WARN);
        AbstractLogger consoleLogger = new ConseleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] argv) {
        AbstractLogger loggerChain = getChainLogger();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        loggerChain.logMessage(AbstractLogger.WARN,
                "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
