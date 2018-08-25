package com.superdzen.headfirstdesignpatterns.ducks;

import com.superdzen.headfirstdesignpatterns.ducks.flyfeature.FlyRocketPowered;
import com.superdzen.headfirstdesignpatterns.ducks.quackfeature.MuteQuack;

/**
 * Created by superdzen@gmail.com on 24.06.2018.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        System.out.println("----------------------------------");
        Duck modelDuck = new ModeDuck();
        modelDuck.display();
        modelDuck.performFly();
        System.out.println("##Change fly behavior");
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();

        System.out.println("----------------------------------");
        DuckDecoy duckDecoy = new DuckDecoy();
        duckDecoy.display();
        duckDecoy.performQuack();
        System.out.println("##Mute duck decoy");
        duckDecoy.setQuackBehavior(new MuteQuack());
        duckDecoy.performQuack();
    }
}
