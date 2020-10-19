package org.campus02.zam.ss2020.practice2.threads.beispiel3;

public class Demo {
    public static void main(String[] args) {
        Worker w = new Worker();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The final value of the counter is : " + Worker.counter);
    }
}
