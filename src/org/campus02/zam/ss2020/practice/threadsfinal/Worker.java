package org.campus02.zam.ss2020.practice.threadsfinal;

public abstract class Worker {
    protected String name;
    protected boolean shouldRun;

    public Worker(String name) {
        this.name = name;
        this.shouldRun = true;
    }

    protected abstract void work();

    protected void printStarted() {
        System.out.println(name + " wurde gestartet");
    }

    protected void printStopped() {
        System.out.println(name + " wurde gestoppt");
    }

    public void stopWorker() {
        shouldRun = false;
    }
}
