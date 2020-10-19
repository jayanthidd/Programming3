package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.timer;

import java.util.Timer;

public class Demo {

    public static void main(String[] args) {
        TimerApp timerApp1 = new TimerApp();
        TimerApp timerApp2 = new TimerApp();

        Thread t1 = new Thread(timerApp1);
        Thread t2 = new Thread(timerApp1);

        t1.start();
        t2.start();

        System.out.println("Press any key to exit");
        if (ConsoleHelper.readline()!=null){
            System.out.println("Shutting down...");
            timerApp1.requestStop();
        }

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
