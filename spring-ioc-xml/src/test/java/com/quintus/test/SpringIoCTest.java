package com.quintus.test;

import com.quintus.ioc3.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    /* 如何创建ioc容器 并读取配置文件*/
    public void createIoC(){
        //创建容器 选择合适的容器即可！

        /*
        * 接口
        *   BeanFactory  ApplicationContext
        * 实现类
        *   可以直接通过构造函数实例化！
        *   ClassPathXmlApplicationContext      读取类路径下的xml配置方式 位置是compile后的classes文件夹内
        *   FileSystemXmlApplicationContext     读取指定文件位置的xml配置方式
        *   AnnotationConfigApplicationContext  读取配置类方式的ioc容器
        *   WebApplicationContext               web项目专属的配置的ioc容器
        * */

        //方法1：直接创建容器并指定配置文件 [推荐]
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //方法2：先创建ioc容器对象，再指定配置文件，再刷新
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.setConfigLocations("spring-03.xml");
        classPathXmlApplicationContext.refresh(); //调用ioc和di的流程，使上步设置配置文件生效

    }

    @Test
    public void getBeanFromIoC(){
        // 1.创建ioc容器对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.setConfigLocations("spring-03.xml");
        classPathXmlApplicationContext.refresh();

        // 2.读取ioc容器的组件
        // 法1：直接通过beanID获取，返回值类型为Object，需要强转
        HappyComponent happyComponent1 = (HappyComponent) classPathXmlApplicationContext.getBean("happyComponent");
        happyComponent1.doWork();

        // 法2：通过beanID和bean的类型Class获得
        HappyComponent happyComponent2 = classPathXmlApplicationContext.getBean("happyComponent", HappyComponent.class);
        happyComponent2.doWork();

        // 法3：直接通过bean的类型class获得
        //TODO 注意！用该方法获得对象，必须保证ioc容器中同类型的bean只有一个
        HappyComponent happyComponent3 = classPathXmlApplicationContext.getBean(HappyComponent.class);
        happyComponent3.doWork();

        // getBean取的是同一个对象，都是配置文件里面声明的那个
        System.out.println(happyComponent1 == happyComponent2);
        System.out.println(happyComponent1 == happyComponent3);
    }
}
