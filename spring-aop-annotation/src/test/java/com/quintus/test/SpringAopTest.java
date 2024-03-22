package com.quintus.test;

import com.quintus.config.JavaConfig;
import com.quintus.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {


    // 如果有接口，则调用jdk动态代理（jdk原生的实现方式），代理对象和目标对象是兄弟关系，所以一定要接口接值
    // 如果没有借口，则使用cglib动态代理，需要继承目标对象实现代理，目标对象和代理对象是父子关系
    // 有aop功能，ioc容器中存储的是代理对象而不是目标对象
    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }
}

