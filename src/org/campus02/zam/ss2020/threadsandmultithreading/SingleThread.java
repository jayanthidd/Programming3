package org.campus02.zam.ss2020.threadsandmultithreading;

public class SingleThread {
    public static void main(String[] args) {
        System.out.println("Single Thread");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.activeCount());
        // single thread reduces the overheads of the application
        // it also reduces the maintenance cost of the application
    }
}
