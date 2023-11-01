package com.bbanddak.bbanddak.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Map;

// 암호화, 복호화 Aspect
@Aspect
@Component
public class EncAndDec {

    private final ParameterNameDiscoverer parameterNameDiscoverer;

    @Autowired
    public EncAndDec(ParameterNameDiscoverer parameterNameDiscoverer) {
        this.parameterNameDiscoverer = parameterNameDiscoverer;
    }

    // Scope : 모든 service의 set method에 설정
    //
    @Around("execution(* com.bbanddak.bbanddak.service.*.set*(..))")
    public Object encryptPassword(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = methodSignature.getParameterNames();

        // 돌면서 parameter중 password 라는 게 들어있으면
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String && paramNames[i].toLowerCase().contains("password")) {
                // Base64 형태로 암호화
                args[i] = Base64.getEncoder().encodeToString(((String) args[i]).getBytes());
            }
        }
        // 작업 진행
        return joinPoint.proceed(args);
    }

    @Around("execution(* com.bbanddak.bbanddak.service.UserServiceMyBatis.getPasswordById(..))")
    public Object decryptPassword(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        // Map 형태의 데이터가 맞는지 확인
        if (result instanceof Map ) {
            Map<String, String> resultMap = (Map<String, String>) result;

            // "password" 라는 wording이 포함된 key가 있다면, value를 가져와 복호화합니다.
            if (resultMap.containsKey("password")) {
                String encryptedPassword = resultMap.get("password");
                String decryptedPassword = new String(Base64.getDecoder().decode(encryptedPassword));
                resultMap.put("password", decryptedPassword); // 복호화된 값을 다시 설정합니다.
            }
        }

        return result;
    }
}
