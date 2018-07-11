package com.superdzen.synchronize;

public class SynchronizedMethods {
    private int sum = 0;
    private static int staticSum = 0;

    public int getSum() {
        return sum;
    }

    public static int getStaticSum() {
        return SynchronizedMethods.staticSum;
    }

    public static void setStaticSum(int staticSum) {
        SynchronizedMethods.staticSum = staticSum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void notSyncCalcMethod() {
        setSum(getSum() + 1);
    }

    public synchronized void syncCalcMethod() {
        setSum(getSum() + 1);
    }

    public static synchronized void syncStaticCalcMethod() {
        setStaticSum(getStaticSum() + 1);
    }
}
