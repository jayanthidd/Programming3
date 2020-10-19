package org.campus02.zam.ss2020.practice.threads1to3a.beispiel2;

public class Worker implements Runnable {
    public static int counter = 0;
    private static Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            while (counter < 20) {
                lock.notifyAll();
                counter++;
                System.out.println(Thread.currentThread().getName() + " : " + counter);
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
