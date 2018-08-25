package com.superdzen.headfirstdesignpatterns.ducks.quackfeature;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println(" - Quack");
    }
}
