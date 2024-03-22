package com.quintus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.quintus")
@EnableAspectJAutoProxy   //开启aspect注解支持
public class JavaConfig {
}
