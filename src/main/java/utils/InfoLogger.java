package utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfoLogger {
    private final static Logger logger = LogManager.getLogger();

    public static void info(String message) {
        logger.log(Level.INFO, message);
    }

    public static void error(String message) {
        logger.log(Level.ERROR, message);
    }
}