package com.superdzen.headfirstdesignpatterns.ducks;

import com.superdzen.headfirstdesignpatterns.ducks.flyfeature.FlyWithWings;
import com.superdzen.headfirstdesignpatterns.ducks.quackfeature.Quack;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println(" - I'm a real Mallard Duck");
    }
}
