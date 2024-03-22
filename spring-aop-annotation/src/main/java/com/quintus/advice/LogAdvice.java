package com.quintus.advice;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *  1.定义方法来存储增强代码（关键代码之外的代码）
 *    具体定义几个方法由插入的位置决定
 *  2.使用注解配置 指定插入目标方法的位置
 *    前置  @Before
 *    后置  @AfterReturning
 *    异常  @AfterThrowing
 *    最后  @After
 *    环绕  @Around
 *
 *    try{
 *        前置
 *        目标关键代码执行
 *        后置
 *    }catch(){
 *        异常
 *    }finally{
 *        最后
 *    }
 *  3.配置切点表达式
 *  4.补全注解
 *    加入ioc容器 @Component
 *    配置切面 @Aspect = 切点 + 增强
 * 5.开启aspect注解的支持
 * */

@Component
@Aspect
public class LogAdvice {

    @Before("execution(* com.quintus.service.impl.*.*(..))")
    public void start(){
        System.out.println("方法开始了");
    }

    @After("execution(* com.quintus.service.impl.*.*(..))")
    public void after(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.quintus.service.impl.*.*(..))")
    public void error(){
        System.out.println("方法报错了");
    }
}
