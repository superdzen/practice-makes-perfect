package com.superdzen.headfirstdesignpatterns.ducks;

import com.superdzen.headfirstdesignpatterns.ducks.flyfeature.FlyNoWay;
import com.superdzen.headfirstdesignpatterns.ducks.quackfeature.Quack;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class ModeDuck extends Duck {

    public ModeDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("This is a model duck");
    }
}
