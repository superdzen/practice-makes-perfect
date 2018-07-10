package com.superdzen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // call methods on the bean
        System.out.println(theCricketCoach.getDailyWorkout());
        System.out.println(theCricketCoach.getDailyFortune());

        // retrieve bean from spring container
        CoderCoach theCoderCoach = context.getBean("myCoderCoach", CoderCoach.class);

        // call methods on the bean
        System.out.println(theCoderCoach.getDailyWorkout());
        System.out.println(theCoderCoach.getDailyFortune());

        // close the context
        context.close();

    }
}
