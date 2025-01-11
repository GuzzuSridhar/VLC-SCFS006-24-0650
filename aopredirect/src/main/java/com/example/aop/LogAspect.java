package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(AopApplication.class);

    // @Before("execution (public String showMain())")
    @Before("execution (public * showMain())")
    public void logBefore() {
        logger.info("The index has been called to display");
    }

    // @After("execution (public String showMain())")
    @After("execution (public * showMain())")
    public void logAfter() {
        logger.info("The index has been called and displayed");
    }

    @Around("execution(public * withdrawAmt(..)) && args(amt)")
    public Object chkAmt(ProceedingJoinPoint pjp, float amt) throws Throwable {
        if (amt > 1000) {
            logger.info("Limit Exceeded");
            String s = "redirect:/";
            return s;
        } else {
            logger.info(amt + " Withdrawn");
        }
        Object res = pjp.proceed();
        return res;

    }
}
