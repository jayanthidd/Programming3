package org.campus02.zam.ss2020.practice.threadconsoleandsync;

import java.util.Date;

public class Timer implements Runnable{
    private Date date;
    private boolean isRunning = true;
    private static Object lock = new Object();

    @Override
    public void run() {
        while (isRunning) {
            synchronized (lock) {
                date = new Date();
                System.out.print("[ " + date.toString());
                System.out.println(", CPUs: " + Runtime.getRuntime().availableProcessors() + ", Freememory: " + Runtime.getRuntime().freeMemory() + " ]");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void requestShutDown(){
        isRunning = false;
    }
}
