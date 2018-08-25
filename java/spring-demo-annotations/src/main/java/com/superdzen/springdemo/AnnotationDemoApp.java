package com.superdzen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        // read Spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get beans from Spring container
        Coach theCoach1 = context.getBean("constructorAutoWiredTennisCoach", Coach.class);
        Coach theCoach2 = context.getBean("setterAutoWiredTennisCoach", Coach.class);
        Coach theCoach3 = context.getBean("fieldAutoWiredTennisCoach", Coach.class);
        PropertiesInjectionTennisCoach theCoach4 = context.getBean("propertiesInjectionTennisCoach", PropertiesInjectionTennisCoach.class);
        Coach thePingPongCoach = context.getBean("pingPongCoach", Coach.class);

        // call a method on the beans
        System.out.println("Tennis coach1: " + theCoach1.getDailyWorkout());
        System.out.println("Tennis coach1: " + theCoach1.getDailyFortune());

        System.out.println("Tennis coach2: " + theCoach2.getDailyWorkout());
        System.out.println("Tennis coach2: " + theCoach2.getDailyFortune());

        System.out.println("Tennis coach3: " + theCoach3.getDailyWorkout());
        System.out.println("Tennis coach3: " + theCoach3.getDailyFortune());


        System.out.println("Tennis coach4 team: " + theCoach4.getEmail());
        System.out.println("Tennis coach4 team: " + theCoach4.getTeam());

        System.out.println("Ping-Pong coach: " + thePingPongCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}