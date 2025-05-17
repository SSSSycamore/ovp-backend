package com.ovp.Aspect;

import com.ovp.annotation.AutoFill;
import com.ovp.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Slf4j
@Component
public class AutoFillAspect {
    @Pointcut("execution(* com.ovp.mapper.*.*(..)) && @annotation(com.ovp.annotation.AutoFill)")
    public void autoFillPointCut() {}

    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint jp) {
        log.info("自动填充切面开始执行");
        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        AutoFill annotation = methodSignature.getMethod().getAnnotation(AutoFill.class);
        OperationType value = annotation.value();
        Object[] args = jp.getArgs();
        if(args == null || args.length == 0){
            return;
        }
        Object entity = args[0];
        if(value == OperationType.INSERT){
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                setCreateTime.invoke(entity, LocalDateTime.now());
                setUpdateTime.invoke(entity, LocalDateTime.now());
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else if (value == OperationType.UPDATE){
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                setUpdateTime.invoke(entity, LocalDateTime.now());
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
