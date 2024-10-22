package com.figures_pack.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    static Logger logger = LogManager.getLogger(LoggingAspect.class);
	//src\main\java\
    @Before("execution(* com.figures_pack.factories.RectangleFactory.createShape(..))")
    public void logBefore() {
        logger.info("Creating rectangle from factory");
        // System.out.println("Creating rectangle from factory");
    }
}