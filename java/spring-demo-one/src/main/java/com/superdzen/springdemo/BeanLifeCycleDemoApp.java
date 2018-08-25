package com.superdzen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {

        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach1 = context.getBean("myCoach1", Coach.class);
        System.out.println("Bean1 created: " + theCoach1);

        Coach theCoach2 = context.getBean("myCoach2", Coach.class);
        System.out.println("Bean2 created: " + theCoach2);
        // close the context
        context.close();
    }
}
