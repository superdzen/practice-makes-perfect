package com.superdzen;

/**
 * Created by superdzen@gmail.com on 21.08.2017.
 */
public class ThreadCom {
    public static void main(String[] args) {
        TickTock tickTock = new TickTock();
        TickTockThread thread1 = new TickTockThread("Tick", tickTock);
        TickTockThread thread2 = new TickTockThread("Tock", tickTock);

        try {
            thread1.thread.join();
            thread2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TickTockThread implements Runnable {
    Thread thread;
    private TickTock ttOb;

    public TickTockThread(String name, TickTock ttOb) {
        this.thread = new Thread(this, name);
        this.ttOb = ttOb;
        thread.start();
    }

    @Override
    public void run() {
        if (!thread.getName().equals("Tock")) {
            for (int i = 0; i < 5; i++) {
                ttOb.tick(true);
            }
            ttOb.tick(false);
        }
        else if (!thread.getName().equals("Tick")) {
            for (int i = 0; i < 5; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }
}

class TickTock {
    private String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }

        System.out.print("Tick ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state = "ticked";
        notify();

        try {
            while (!state.equals("tocked")) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }

        System.out.println("Tock");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state = "tocked";
        notify();

        try {
            while (!state.equals("ticked")) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}