package com.bbanddak.bbanddak.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Logging Aspect
@Aspect
@Component
public class Logging {

    // 해당 서비스 수행전에 로그를 남김
    @Before("execution(* com.bbanddak.bbanddak.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before execution: " + joinPoint.getSignature());
    }

    // 해당 서비스 수행후에 로그를 남김
    @After("execution(* com.bbanddak.bbanddak.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After execution: " + joinPoint.getSignature());
    }
}
