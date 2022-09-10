package gliese832c.circulatorySystem.util;

import gliese832c.circulatorySystem.CirculatorySystem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CirculatorySystemLogger {
    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = LogManager.getFormatterLogger(CirculatorySystem.MOD_ID);
        }
        return logger;
    }
}
