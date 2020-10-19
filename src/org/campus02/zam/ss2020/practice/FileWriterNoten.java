package org.campus02.zam.ss2020.practice;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterNoten {
    public static void main(String[] args) {
        FileReader fileReader = null;
        PrintWriter printWriter = new PrintWriter(System.out);
        try {
            fileReader = new FileReader("url.txt");

            int c;
            while ((c = fileReader.read()) != -1) {
                printWriter.print((char) c);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            printWriter.close();
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
