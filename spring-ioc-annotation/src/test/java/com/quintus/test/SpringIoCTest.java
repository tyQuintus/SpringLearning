package com.quintus.test;

import com.quintus.ioc1.XxxDao;
import com.quintus.ioc1.XxxService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    @Test
    public void testIoC1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        XxxDao bean = applicationContext.getBean(XxxDao.class);

        System.out.println("bean:" + bean);

        Object bean1 = applicationContext.getBean("xxxService");
        System.out.println("bean1:" + bean1);
    }
}
