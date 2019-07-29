package com.sunkuet02.springboot2.config.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfiguration {

    private final static Logger logger = LogManager.getLogger(AopConfiguration.class);

    @Around("execution(public * com.sunkuet02.springboot2.controllers..*(..))")
    public Object monitorTimeOfController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName = proceedingJoinPoint.getSignature().getName();
        logger.info("Started executing : " + methodName);

        Object obj;
        try {
            obj = proceedingJoinPoint.proceed();
            logger.info("Finished executing : " + methodName);
            return obj;
        } catch (Throwable e) {
            throw e;
        } finally {
            logger.info("Method " + methodName + " execution lasted:" + (System.currentTimeMillis() - startTime) + " milliseconds");
        }
    }
}
