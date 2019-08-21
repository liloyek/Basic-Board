package com.authboard.demo.board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
<Terms related to AOP>

Aspect : Common functions to be applied. It consists of more than one Pointcut and Advice.
Advice : Implementation of Aspect. It's inserted to Joinpoint and works.
Joinpoint : When to apply Advice. In Spring framework, it's only available when a method is executed.
Pointcut : The process of selecting the Joinpoint to apply Advice or the module that defines those functions.
Target : Target for Advice.
Weaving : The behavior itself that inserts common functions to the target.
*/

@Slf4j
@Component
@Aspect // Use AOP
public class LoggerAspect {
    // There are five kinds of Advice and @Around is one of them.
    // execution is the expression of pointcut to define the method to apply AOP.
    @Around("execution(* board..controller.*Controller.*(..)) or" +
            "execution(* board..service.*Impl.*(..)) or" +
            "execution(* board..dao.*Mapper.*(..))")
    public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();
        if(name.indexOf("Controller") > -1){
            type = "Controller  \t:  ";
        }
        else if(name.indexOf("Service") > -1){
            type = "ServiceImpl   \t:   ";
        }
        else if(name.indexOf("Mapper") > -1){
            type = "Mapper  \t\t:  ";
        }
        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
