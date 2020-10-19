package org.campus02.zam.ss2020.practice;

import java.io.*;

public class BufferedReaderStop {
    public static void main(String[] args) {
        System.out.println("Input data.  Press STOP to quit");
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("url.txt"));
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (!(line = bufferedReader.readLine()).equals("STOP")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
