package com.superdzen.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FieldAutoWiredTennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public FieldAutoWiredTennisCoach() {
        System.out.println(">> FieldAutoWiredTennisCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // init method
    @PostConstruct
    public void doStartupStuff() {
        System.out.println(">> FieldAutoWiredTennisCoach is doing init method");
    }

    // destroy method
    @PreDestroy
    public void doCleanupStuff() {
        System.out.println(">> FieldAutoWiredTennisCoach is doing destroy method");
    }

}
