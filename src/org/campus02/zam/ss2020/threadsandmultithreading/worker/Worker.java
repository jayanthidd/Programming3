package org.campus02.zam.ss2020.threadsandmultithreading.worker;

public class Worker implements Runnable {
    private char sign;

    public Worker(char sign) {
        this.sign = sign;
    }

    @Override
    public void run() {
        for(int i =0; i<100; i++) {
            System.out.println(i + Thread.currentThread().getName()+ " " + sign);
        }
        try{
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
