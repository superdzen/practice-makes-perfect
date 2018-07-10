package com.superdzen.springdemo;

import java.util.Random;

public class CoderFortuneService implements FortuneService {

    private String[] fortunes = {"You are super coder!"
            , "You are awesome coder!"
            , "You are great coder!"};

    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes[random.nextInt(fortunes.length)];
    }
}
