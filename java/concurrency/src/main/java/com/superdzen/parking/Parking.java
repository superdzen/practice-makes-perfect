package com.superdzen.parking;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by superdzen@gmail.com on 26.08.2017.
 * This class emulates how parking works using Semaphores
 */
public class Parking {
    private int parkingLength;
    private boolean[] parkingPlaces;
    private Semaphore semaphore;

    public Parking(int parkingLength) {
        this.parkingLength = parkingLength;
        parkingPlaces = new boolean[parkingLength];

        for (int i = 0; i < parkingPlaces.length; i++) {
            parkingPlaces[i] = true;                    // "true"  means all the places initially free
        }
        semaphore = new Semaphore(parkingLength);
    }

    public Semaphore getSemaphore() {
        return this.semaphore;
    }

    public boolean[] getParkingPlaces() {
        return parkingPlaces;
    }

    public int getParkingLength() {
        return parkingLength;
    }

    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking(3);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ParkingCar parkingCar = new ParkingCar(random.nextInt(1000), parking);
        }
    }
}

