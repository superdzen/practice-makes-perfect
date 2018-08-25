package com.superdzen.headfirstdesignpatterns.ducks;

import com.superdzen.headfirstdesignpatterns.ducks.quackfeature.Squeak;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class DuckDecoy extends Decoy {

    public DuckDecoy() {
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("This is a duck decoy");
    }
}
