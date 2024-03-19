package com.quintus.config;

/*
* java的配置类，替代xml配置文件
*   1.包扫描注解配置 @ComponentScan
*   2.引用外部的配置文件 @PropertySource
*   3.声明第三方依赖的bean组件
*
* 步骤1：添加 @Configuration 代表我们是配置类
* 步骤2：实现上面的三个功能注解
*
* */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(value = "com.quintus.ioc01")
@PropertySource(value = "classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {

}
