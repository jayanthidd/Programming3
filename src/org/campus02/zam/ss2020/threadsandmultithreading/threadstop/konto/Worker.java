package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.konto;

import java.io.ObjectInputStream;

public class Worker implements Runnable {
    private char sign;
    private Konto k1;
    private Konto k2;
    private final int count = 100;
    private final int sleepInterval = 10;

    public Worker(char sign, Konto k1, Konto k2) {
        this.sign = sign;
        this.k1 = k1;
        this.k2 = k2;
    }
    Object lock = new Object();
    @Override
    public void run() {
        //synchronized (lock) {
            for (int i = 0; i < count; i++) {
                double wert1 = k1.getWert();
                System.out.println(sign + " wert von k1 ermittlet");

                double wert2 = k2.getWert();
                System.out.println(sign + " wert von k2 ermittlet");

                k1.setWert(wert1 - 10);
                System.out.println(sign + " 10 von k1");

                k2.setWert(wert2 + 10);
                System.out.println(sign + " 10 von k2");
            }
        //}
        try {
            Thread.sleep(sleepInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
