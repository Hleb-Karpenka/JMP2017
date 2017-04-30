package com.epam.training.shop.service.impl;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BenchmarkAspect {

    @Around("within(com.epam.training.shop.service.impl..)")
    public Object benchTime(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before");
        Object retVal = pjp.proceed();

        System.out.println("After");
        return retVal;
    }

}
