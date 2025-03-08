package io.github.gandhivivek96.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private LoggerUtility()
    {

    }

    public static Logger getLogger(Class<?> clazz )
    {
        return LogManager.getLogger(clazz);
    }

}
