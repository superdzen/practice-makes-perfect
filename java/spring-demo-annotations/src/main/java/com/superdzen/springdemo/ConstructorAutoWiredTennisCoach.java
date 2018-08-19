package com.superdzen.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorAutoWiredTennisCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    public ConstructorAutoWiredTennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        System.out.println(">> ConstructorAutoWiredTennisCoach: inside the constructor");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
