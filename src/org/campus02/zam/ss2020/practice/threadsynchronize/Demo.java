package org.campus02.zam.ss2020.practice.threadsynchronize;

public class Demo {
    public static void main(String[] args) {
        Konto k1 = new Konto(100);
        Konto k2 = new Konto(200);

        Worker w = new Worker("Mariappan", k1, k2);
        Worker w2 = new Worker("Munuswamy", k2, k1);

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" K1 has : " + k1.getWert() + " K2 has : " + k2.getWert());
        System.out.println("Task completed");
    }
}
