package com.bbanddak.bbanddak.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 실행시간을 측정하는 Aspect
@Aspect
@Component
public class RunningTIme {

    @Around("execution(* com.bbanddak.bbanddak.mapper.*.*(..)) || execution(* com.bbanddak.bbanddak.repository.*.*(..))") // 패키지 및 메서드 경로에 맞게 변경
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime; // 시간차를 파악하여

        System.out.println("Method : " + joinPoint.getSignature() + " RunningTime : " + executionTime + "ms");

        return result;
    }
}
