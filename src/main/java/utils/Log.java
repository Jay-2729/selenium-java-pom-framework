package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger LOGGER =
            LogManager.getLogger(
                    Log.class);

    public static void info(
            String message) {

        LOGGER.info(message);
    }

    public static void pass(
            String message) {

        LOGGER.info(
                "PASS : "
                        + message);
    }

    public static void fail(
            String message) {

        LOGGER.error(
                "FAIL : "
                        + message);
    }
}
