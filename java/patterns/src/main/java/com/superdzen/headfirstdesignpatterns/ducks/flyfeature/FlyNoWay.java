package com.superdzen.headfirstdesignpatterns.ducks.flyfeature;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" - I can't fly.");
    }
}
