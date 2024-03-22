package com.quintus.test;

import com.quintus.config.JavaConfig;
import com.quintus.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();

    }
}
