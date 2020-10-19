package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.konto;

public class Demo {
    Konto k1 = new Konto(100);
    Konto k2 = new Konto(200);

    Runnable w1 = new Worker('A', k1, k2);
    Runnable w2 = new Worker('B', k2, k1);

    Thread t1 = new Thread(w1);
    Thread t2 = new Thread(w2);


}
