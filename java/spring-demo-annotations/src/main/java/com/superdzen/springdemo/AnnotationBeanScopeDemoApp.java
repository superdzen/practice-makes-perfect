package com.superdzen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("fieldAutoWiredTennisCoach", FieldAutoWiredTennisCoach.class);
        Coach alphaCoach = context.getBean("fieldAutoWiredTennisCoach", FieldAutoWiredTennisCoach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        // print out the result
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        context.close();
    }
}
