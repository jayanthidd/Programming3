package org.campus02.zam.ss2020.threadsandmultithreading.worker;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Runnable worker1= new Worker('A');
        Runnable worker2 = new Worker('B');

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Fertig");
    }
}
