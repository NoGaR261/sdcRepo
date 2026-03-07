import utils.*;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

public class SdcMain {
    private static final Logger LOGGER = Logger.getLogger(SdcMain.class.getName());

    public static void main(String[] args) {
        LOGGER.info("SDC app started.");

        if (args.length == 0) {
            LOGGER.warning("The first argument was not present. App is closing");
            return;
        }

        LOGGER.info("Processing argument: " + args[0]);
        boolean plainFormat = args.length > 1 && Boolean.parseBoolean(args[1]);

        if (!plainFormat) {
            LOGGER.info("If you want to use plain format, please provide 'true' as the second argument. ");
        }

        DataSource dataSource = new ExcelReader(args[0], 1, 0);
        DataParser dataParser = new NumberParser();
        DataChecker primeChecker = new PrimeChecker();
        DataPrinter dataPrinter = new ConsoleLoggerPrinter(plainFormat);

        try (dataSource) {
            dataSource.readValues()
                    .map(dataParser::parse)
                    .flatMap(Optional::stream)
                    .filter(primeChecker::isPrime)
                    .forEach(dataPrinter::printValue);
        } catch (IOException e) {
            LOGGER.severe("An error occurred while reading the Excel file: " + e.getMessage());
        }

        LOGGER.info("Processing is done.");
    }
}