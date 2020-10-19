package org.campus02.zam.ss2020.practice2.threadsfinal;

public class Demo {
    public static void main(String[] args) {
        TimePrintWorker timePrintWorker= new TimePrintWorker("Time Print Worker");
        FileReadWorker fileReadWorker = new FileReadWorker("Flie Read Worker", "output.txt");

        Thread t1 = new Thread(timePrintWorker);
        Thread t2 = new Thread(fileReadWorker);

        t1.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timePrintWorker.stopWorker();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Both workers have completed their tasts!");
    }
}
