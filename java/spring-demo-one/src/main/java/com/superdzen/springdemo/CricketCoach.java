package com.superdzen.springdemo;

public class CricketCoach implements Coach {

    // define a private field for the dependency
    private FortuneService fortuneService;

    private String emailAddress;
    private String team;

    // define a default constructor
    public CricketCoach() {
    }

    // define a setter for dependency injection
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "I am your CricketCoach. Practice fast bowling for 15 minutes   ";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
