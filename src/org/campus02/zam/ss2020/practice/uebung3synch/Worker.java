package org.campus02.zam.ss2020.practice.uebung3synch;

public class Worker implements Runnable {
    private int counter = 0;

    public Worker() {
    }
    public static Object lock = new Object();

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (counter < 21) {
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + " : " + counter++);

                try {
                    Thread.sleep(1000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notifyAll();
        }
    }
}
