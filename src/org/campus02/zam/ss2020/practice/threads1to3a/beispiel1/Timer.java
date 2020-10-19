package org.campus02.zam.ss2020.practice.threads1to3a.beispiel1;

import java.util.Date;

public class Timer implements Runnable{
    private boolean isRunning = true;
    private static Object lock = new Object();
    @Override
    public void run() {
        while (isRunning) {
            synchronized (lock) {
                Date d = new Date();
                System.out.print("[ " + d.toString());
                System.out.print(", CPUs : " + Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem : " + Runtime.getRuntime().freeMemory() + " ]");
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void requestShutdown() {
        isRunning = false;
    }
}
