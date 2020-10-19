package org.campus02.zam.ss2020.practice.threadsfinal;

import java.io.*;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {
    private String path;
    public ArrayList<String> lines;

    public FileReadWorker(String name, String path) {
        super(name);
        this.path = path;
        this.lines = new ArrayList<>();
    }

    @Override
    public void run() {
        work();
    }

    @Override
    protected void work() {
        printStarted();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                lines.add(line);
                System.out.println(line);
                if (!shouldRun){
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printStopped();
    }
}
