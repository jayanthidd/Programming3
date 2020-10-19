package org.campus02.zam.ss2020.threadsandmultithreading;

public class RunnableExample implements Runnable {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
        Runnable runnable = new RunnableExample();

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        System.out.println("Starting thread");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Inside new Thread : " + Thread.currentThread().getName());
    }
}
