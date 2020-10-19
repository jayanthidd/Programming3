package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.timer;

import java.io.ObjectInputStream;
import java.util.Date;

/*
Schreiben Sie eine Konsolenanwendung mit einem Hintergrund-Thread,
welcher im Sekundentakt die aktuelle Uhrzeit ausgibt Aktuelle Uhrzeit:
    Date d = new Date();
    System.out.println(d.toString())
Per Tastendruck / Eingabe eines Zeichens soll die Anwendung (und der Thread „höflich“)
gestoppt werden können.
 */
public class TimerApp implements Runnable {
    boolean isRunning = true;

    public void requestStop(){
        isRunning = false;
    }

    private Object lock = new Object();

    @Override
    public void run() {
        while (isRunning){
            synchronized (lock) {
                Date d = new Date();
                System.out.print("[");
                System.out.print(Thread.currentThread().getName() +" :");
                System.out.print(d.toString());
                System.out.print(",CPUs: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.print("]");
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
