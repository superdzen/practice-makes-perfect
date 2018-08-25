package com.superdzen.headfirstdesignpatterns.ducks.quackfeature;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println(" - Squeak");
    }
}
