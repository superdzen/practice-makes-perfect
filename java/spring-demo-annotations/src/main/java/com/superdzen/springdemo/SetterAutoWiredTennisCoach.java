package com.superdzen.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterAutoWiredTennisCoach implements Coach {

    private FortuneService fortuneService;

    public SetterAutoWiredTennisCoach() {
        System.out.println(">> SetterAutoWiredTennisCoach: inside default constructor");
    }
    //    @Autowired
//    public SetterAutoWiredTennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Autowired
    public void setFortuneService(FortuneService theFortuneService) {
        System.out.println(">> SetterAutoWiredTennisCoach: injecting FortuneService in setFortuneService");
        this.fortuneService = theFortuneService;
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
