package org.campus02.zam.ss2020.practice;

import java.io.*;

public class PrintWriterStop {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try{
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(new OutputStreamWriter(System.out));

            String line = null;
            while (!(line = bufferedReader.readLine()).equals("stop")){
                printWriter.println(line);
                printWriter.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.close();
        }
    }
}
