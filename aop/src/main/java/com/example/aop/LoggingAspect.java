package com.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(AopApplication.class);

    // Before advice: Log before any public method execution in the application
    @Before("execution(public String performOperation())")
    public void logBefore() {
        System.out.println("Before method execution...");
        logger.info("Operation perform started");
    }

    // // After advice: Log after any public method execution in the application
    @After("execution(public String performOperation())")
    public void logAfter() {
        System.out.println("After method execution...");
        logger.info("Operation perform Completed");
    }
}
