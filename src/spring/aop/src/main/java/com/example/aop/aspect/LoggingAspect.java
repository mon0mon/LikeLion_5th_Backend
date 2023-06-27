/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-27 PM 2:02
 */

package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    //  컨트롤러 클래스
    //  @Before: Advice, 실제로 실행될 코드를 나타냄
    //  @Before.value: Pointcut Designator, 어느 JoinPoint에서
    //  실행될 것인지

    //  this: 클래스 instance 지정
//    @Before("this(com.example.aop.controller.AopController)")
    //  within: 클래스 또는 패키지 지정
//    @Before("within(com.example.aop.controller.AopController)")
    @After("within(com.example.aop.controller.AopController)")
    //  @annotation: 어노테이션 지정
    public void logParameters(JoinPoint joinPoint) {
//        log.info("hello aop!");
        //  JointPoint의 정보를 담은 객체
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(methodSignature.getName());
        Object[] arguments = joinPoint.getArgs();
        //  인자가 없을 때
        if (arguments.length == 0) {
            log.info("no args");
        }
        for (Object argument : arguments) {
            log.info("argument : [{}]", argument);
        }
    }
}
