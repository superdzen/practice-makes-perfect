package com.superdzen.headfirstdesignpatterns.ducks;

import com.superdzen.headfirstdesignpatterns.ducks.quackfeature.QuackBehavior;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public abstract class Decoy {
    public abstract void display();

    QuackBehavior quackBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
