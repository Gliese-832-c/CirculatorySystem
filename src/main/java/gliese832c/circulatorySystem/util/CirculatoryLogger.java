package gliese832c.circulatorySystem.util;

import gliese832c.circulatorySystem.CirculatorySystem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CirculatoryLogger {
    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = LogManager.getFormatterLogger(CirculatorySystem.MOD_ID);
        }
        return logger;
    }



    public static void info(String infoMessage) {
        getLogger().info(infoMessage);
    }

    public static void error(String infoMessage) {
        getLogger().error(infoMessage);
    }

    public static void debug(String infoMessage) {
        getLogger().debug(infoMessage);
    }

    public static void fatal(String infoMessage) {
        getLogger().fatal(infoMessage);
    }
}
