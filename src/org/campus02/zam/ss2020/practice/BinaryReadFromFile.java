package org.campus02.zam.ss2020.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryReadFromFile {
    public static void main(String[] args) {
        File file = new File("output.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int read;
            int count = 0;
            while ((read = fileInputStream.read()) != -1) {
                char c[] = Character.toChars(read);
                System.out.print(c[0]);
                count++;
            }
            System.out.println(count);
        }catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
