package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.example;

public class Worker implements Runnable {
    public int counter= 0;
    private final int sleepInterval = 100;
    private static Object lock = new Object();
    public Worker() {
        this.counter = 0;

    }
    @Override
    public void run() {
        synchronized (lock) {
            while (counter < 21) {
                lock.notify();

                System.out.println(Thread.currentThread().getName() + "makes other threads free");
                System.out.println(Thread.currentThread().getName() + " Counter : " + counter);
                counter++;
                try {
                    Thread.sleep(sleepInterval);
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
        }
    }
}
