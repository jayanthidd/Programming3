package org.campus02.zam.ss2020.practice.threads1to3a.beispiel1;

public class Demo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Thread t = new Thread(timer);
        Thread t1 = new Thread(timer);

        ConsoleHelper consoleHelper = new ConsoleHelper();
        t.start();
        t1.start();
        if (consoleHelper.readLine()!=null){
            timer.requestShutdown();
        }
        try {
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Process complete");
    }
}
