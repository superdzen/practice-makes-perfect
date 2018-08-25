package com.superdzen.parking;

import java.util.Random;

/**
 * Created by superdzen@gmail.com on 26.08.2017.
 * This class emulates a parking car that use a semaphore
 */

public class ParkingCar implements Runnable {
    private int carNumber;
    private Parking parking;

    public ParkingCar(int carNumber, Parking parking) {
        this.carNumber = carNumber;
        this.parking = parking;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void tryToPark() {
        System.out.printf("Car #%3d arrived to the parking\n", carNumber);

        int parkingNumber = -1;
        try {
            // try to occupy a parking place
            parking.getSemaphore().acquire();

            synchronized (parking.getParkingPlaces()) {
                boolean[] parkingPlaces = parking.getParkingPlaces();
                for (int i = 0; i < parkingPlaces.length; i++) {
                    if (parkingPlaces[i]) {
                        parkingNumber = i;
                        System.out.printf("Car #%3d parked on the lot #%d\n", carNumber, parkingNumber);
                        parkingPlaces[parkingNumber] = false;   // the parking place officially busy
                        break;
                    }
                }
            }
            //add some delay;
            Random random = new Random();
            Thread.sleep(random.nextInt(10) * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //try to release a parking place
            System.out.printf("Car #%3d left the lot #%d\n", carNumber, parkingNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (parking.getParkingPlaces()) {
                parking.getParkingPlaces()[parkingNumber] = true;
            }
            parking.getSemaphore().release();

        }

    }

    @Override
    public void run() {
        this.tryToPark();
    }
}