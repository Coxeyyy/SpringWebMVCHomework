package com.coxey.app.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggerAOP {
    private final Logger log = Logger.getLogger(LoggerAOP.class.getName());

    @After("execution (* com.coxey.app.controller..*.*(..))")
    public void loggingAfterMethodCalling(JoinPoint joinPoint) {
        log.info("Закончил работу метод -> " +  joinPoint.getSignature().getName());
    }
}
