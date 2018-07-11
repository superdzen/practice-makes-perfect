package com.superdzen.javapro.FactoryMethod;

import java.util.Date;

/**
 * Created by superdzen@gmail.com on 03.06.2018.
 */
public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker watchMaker = getWatchMakerByName("Digital");

        Watch watch = watchMaker.createWatch();
        watch.showTimes();
    }

    public static WatchMaker getWatchMakerByName(String maker) {
        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        }
        throw new RuntimeException("Неподдерживаемый тип часов" + maker);
    }
}

interface Watch {
    void showTimes();
}

class DigitalWatch implements Watch {

    @Override
    public void showTimes() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTimes() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}