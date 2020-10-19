package org.campus02.zam.ss2020.practice.threadsfinaluebung;

public class Demo {
    public static void main(String[] args) {
        TimePrintWorker timePrintWorker = new TimePrintWorker("Munuswamy");
        FileReadWorker fileReadWorker = new FileReadWorker("Mariappan", "output.txt");

        Thread thread1 = new Thread(timePrintWorker);
        Thread thread2 = new Thread(fileReadWorker);

        thread1.start();
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timePrintWorker.stopWorker();
    }
}
