package com.quintus.test;

import com.quintus.config.JavaConfiguration;
import com.quintus.ioc01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void test(){
        // 1.创建IoC容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        //或
        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
        applicationContext1.register(JavaConfiguration.class);
        applicationContext1.refresh();  //刷新后才会做IoC和DI操作


        // 2.获取Bean
        StudentController bean = applicationContext.getBean(StudentController.class);

        System.out.println("bean:" + bean);
    }
}
