package com.superdzen;

/**
 * Created by superdzen@gmail.com on 20.08.2017.
 */
public class UseThreads {

    public static void main(String[] args) {
        System.out.println("Start");

        TestThread1 testThread1 = new TestThread1("Child1");
        TestThread2 testThread2 = new TestThread2("Child2");

      //  while (testThread2.isAlive() || testThread1.newThread.isAlive());
        try {
            testThread1.newThread.join();
            testThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("End");
    }

}

class TestThread1 implements Runnable {

    Thread newThread;

    public TestThread1(String name) {
        newThread = new Thread(this, name);
        newThread.start();
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(800);
                if (i % 2 == 0) {
                    System.out.println(newThread.getName() + " - Tik");
                } else {
                    System.out.println(newThread.getName() + " - Tak");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class TestThread2 extends Thread {

    public TestThread2(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - Tak");
                } else {
                    System.out.println(Thread.currentThread().getName() + " - Tik");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}