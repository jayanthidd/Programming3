package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.worker;

import org.campus02.zam.ss2020.threadsandmultithreading.threadstop.worker.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        Worker worker1= new Worker('A');
        Worker worker2 = new Worker('B');
        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);
        t1.start();
        t2.start();
        System.out.println("Press a key to stop the threads");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        System.out.println(str);
        if (str!=null){
            System.out.println("Shutting down...");
            worker1.requestShutDown();
            worker2.requestShutDown();
        }
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fertig");
    }
}