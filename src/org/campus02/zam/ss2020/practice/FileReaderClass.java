package org.campus02.zam.ss2020.practice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderClass {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\nxf49434\\Desktop\\Jay\\Programming3\\text.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fr = null;
        try {
            fr = new FileReader(file);

            int hello;
            while ((hello = fr.read()) != -1) {
                System.out.println((char) hello);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
