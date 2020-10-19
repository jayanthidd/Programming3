package org.campus02.zam.ss2020.practice.threadconsoleandsync;

public class Demo {
    public static void main(String[] args) {
        Timer t1 = new Timer();

        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t1);

        thread.start();
        thread1.start();

        if (ConsoleHelper.consoleEntry()!=null){
            t1.requestShutDown();
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Process completed");
    }
}
