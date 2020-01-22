package com.jin.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DaoAop {

    @Around("countDaoTime()")
    public Object count(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        String name = "-";
        String result = "Y";
        try {
            name = pjp.getSignature().toString();
            return pjp.proceed();
        } catch (Throwable e) {
            result = "N";
            throw  e;
        } finally {
            long end = System.currentTimeMillis();
            log.info("daoTime {};{};{}ms", name, result, end - start);
        }
    }

    @Pointcut("execution(* com.jin.demo.dao..*(..))")
    public void countDaoTime() {}
}
