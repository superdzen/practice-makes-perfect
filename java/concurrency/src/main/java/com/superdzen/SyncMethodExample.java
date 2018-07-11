package com.superdzen;

/**
 * Created by superdzen@gmail.com on 20.08.2017.
 */
public class SyncMethodExample {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        MyThread thread1 = new MyThread("Thread1", ar);
        MyThread thread2 = new MyThread("Thread2", ar);
    }
}


class ArraysMethods {
    private long sum;

    long sumArray(int[] array) {
        sum = 0;
        for (int i : array) {
            sum += i;
            System.out.println("Текущее значение суммы = " + sum + ". Для потока " + Thread.currentThread().getName());
        }
        return sum;
    }
}


class MyThread implements Runnable {
    Thread thisThread;
    int[] arr;
    long answer;
    static ArraysMethods arraysMethods = new ArraysMethods();

    public MyThread(String name, int[] array) {
        thisThread = new Thread(this, name);
        arr = array;
        thisThread.start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + thisThread.getName());
        synchronized (arraysMethods) {
            answer = arraysMethods.sumArray(arr);
        }
        System.out.println("Окончание потока " + thisThread.getName());
    }
}