package org.campus02.zam.ss2020.threadsandmultithreading.threadsfinal;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        TimePrintWorker timePrintWorker = new TimePrintWorker("Time Print Worker");
        FileReadWorker fileReadWorker = new FileReadWorker("File Read Worker", "output.txt");

        Thread t1 = new Thread(timePrintWorker);
        Thread t2 = new Thread(fileReadWorker);

        t1.start();
        t2.start();

        t2.join();
        timePrintWorker.stopWorker();
        t1.join();
        System.out.println("Fertig mit allen Arbeiten");
    }
}
