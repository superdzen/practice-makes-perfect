package com.superdzen.springdemo;

import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Play Ping-Pong!";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
