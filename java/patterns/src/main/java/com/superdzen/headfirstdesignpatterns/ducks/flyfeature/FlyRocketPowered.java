package com.superdzen.headfirstdesignpatterns.ducks.flyfeature;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" - I'm flying with a rocket!");
    }
}
