package org.campus02.zam.ss2020.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionsUebung {
    public static void main(String[] args) {
        File file = new File("zam.txt");
        String fileSeparator = System.getProperty("file.separator");
        System.out.println("File Separator : " + fileSeparator);
        System.out.println("C:" + fileSeparator + "Users" + fileSeparator + "nxf49434" + fileSeparator + "Jayanthi" + fileSeparator + "hello.txt");
        File file2 = new File("C:" + fileSeparator + "Users" + fileSeparator + "nxf49434" + fileSeparator + "Downloads" + fileSeparator + "Jayanthi" + fileSeparator + "hello.txt");
        try {
            if (file2.createNewFile()) {
                System.out.println(file2.getAbsolutePath() + "  Filename : " + file2.getName());
                System.out.println("File has been created!");
            }
            else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catchInsideFinally("umlaute.txt");
    }
    public static void catchInsideFinally(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try{
                if(reader != null) {
                    reader.close();
                }
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
