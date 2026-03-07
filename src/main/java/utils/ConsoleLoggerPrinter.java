package utils;

import java.math.BigInteger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLoggerPrinter implements DataPrinter {

    private final Logger logger;

    public ConsoleLoggerPrinter(boolean usePlainFormatter) {
        logger = Logger.getLogger(ConsoleLoggerPrinter.class.getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.INFO);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);

        if (usePlainFormatter) {
            consoleHandler.setFormatter(new PlainFormatter());
        }

        logger.addHandler(consoleHandler);
    }


    @Override
    public void printValue(BigInteger data) {
        logger.info(data.toString());
    }
}
