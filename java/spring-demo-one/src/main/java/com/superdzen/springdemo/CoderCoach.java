package com.superdzen.springdemo;

public class CoderCoach implements Coach {
    private CoderFortuneService coderFortuneService;

    public CoderCoach() {
    }

    public CoderCoach(CoderFortuneService coderFortuneService) {
        this.coderFortuneService = coderFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Get a course on udemy.com";
    }

    @Override
    public String getDailyFortune() {
        return coderFortuneService.getFortune();
    }
}
