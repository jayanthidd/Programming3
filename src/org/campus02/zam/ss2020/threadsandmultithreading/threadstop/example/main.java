package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.example;

public class main {
    public static void main(String[] args) {
        Worker w1 = new Worker();

        Thread t1= new Thread(w1);
        Thread t2 = new Thread(w1);

        t2.start();
        t1.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ "Counter is completed ");
    }
}
