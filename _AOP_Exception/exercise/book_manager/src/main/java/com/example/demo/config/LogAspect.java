package com.example.demo.config;

import org.apache.tomcat.jni.Local;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.example.demo.controller.BookController.update*(..))")
    public void updateBookPointCut(){
    }

//    @Before("updateBookPointCut()")
//    public void beforeCallMethodUpdate(JoinPoint joinPoint){
//        System.err.println("Start method name: " +joinPoint.getSignature().getName()
//        + " Time " + LocalDate.now());
//    }

    @Around("updateBookPointCut()")
    public Object aroundThrowingUpdateBook(ProceedingJoinPoint proceedingJoinPoint){
        System.err.println("Before method time "+ LocalDateTime.now());
        Object value = null;

        try {
            value = proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            System.err.println("Throwing method time "+ LocalDateTime.now());
            throwable.printStackTrace();
        }
        System.err.println("After method time "+ LocalDateTime.now()+ "Return value = "+value);
        return value;
    }
}
