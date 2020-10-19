package org.campus02.zam.ss2020.threadsandmultithreading.threadsfinal;

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
        try {
            work();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void work() throws IOException {
        printStarted();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String content = null;
        while ((content = bufferedReader.readLine())!=null){
            lines.add(content);
            System.out.println(content);
            try {
                Thread.sleep(1000);// not sure of this is what he meant
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!shouldRun) {
                break;
            }
        }
        bufferedReader.close();
        printStopped();
    }
}
