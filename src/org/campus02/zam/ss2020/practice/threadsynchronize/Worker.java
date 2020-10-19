package org.campus02.zam.ss2020.practice.threadsynchronize;

public class Worker implements Runnable {
    private String name;
    private Konto k1;
    private Konto k2;

    public Worker(String name, Konto k1, Konto k2) {
        this.name = name;
        this.k1 = k1;
        this.k2 = k2;
    }

    private static Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                double wert1 = k1.getWert();
                double wert2 = k2.getWert();

                k1.setWert(wert1 - 10);
                k2.setWert(wert2 + 10);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
