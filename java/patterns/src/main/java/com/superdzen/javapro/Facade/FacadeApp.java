package com.superdzen.javapro.Facade;

/**
 * Created by superdzen@gmail.com on 28.05.2018.
 */
public class FacadeApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}


class Computer {
    Power power = new Power();
    DVD dvd = new DVD();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.loadData();
        hdd.copyFromDVD(dvd);
        power.off();
    }
}

class Power {
    void on() {
        System.out.println("Power on");
    }

    void off() {
        System.out.println("Power off");
    }
}

class DVD {
    private boolean hasData = false;

    public boolean hasData() {
        return hasData;
    }

    public void loadData() {
        hasData = true;
    }

    public void unloadData() {
        hasData = false;
    }
}

class HDD {
    void copyFromDVD(DVD dvd) {
        if (dvd.hasData()) {
            System.out.println("Copying from DVD to HDD");
        } else {
            System.out.println("No data in DVD");
        }
    }
}