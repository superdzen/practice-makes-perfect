package com.superdzen.springdemo;

public class SoccerCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Play football";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
