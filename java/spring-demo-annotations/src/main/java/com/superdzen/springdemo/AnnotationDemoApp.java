package com.superdzen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        // read Spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get beans from Spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach thePingPongCoach = context.getBean("pingPongCoach", Coach.class);
        // call a method on the bean
        System.out.println("Tennis coach: " + theCoach.getDailyWorkout());
        System.out.println("Tennis coach: " + theCoach.getDailyFortune());
        System.out.println("Ping-Pong coach: " + thePingPongCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}