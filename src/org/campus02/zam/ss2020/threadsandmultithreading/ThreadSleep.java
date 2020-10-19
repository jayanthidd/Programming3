package org.campus02.zam.ss2020.threadsandmultithreading;

public class ThreadSleep extends Thread {

    public void run() {
        for (int i = 1; i<5; i++) {
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        ThreadSleep t1 = new ThreadSleep();
        ThreadSleep t2 = new ThreadSleep();

        t1.start(); // SInce this class extends Thread, it expects to have a method called run.
        // When we call start, it looks for the run method and executes it.  Nothing else will be executed.
        t2.start();
    }
}
