package org.campus02.zam.ss2020.Reader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File file = new File("campus02-test.txt");


        String fileSeparator = System.getProperty("file.separator");
        File file2 = new File ("C:" + fileSeparator +"Jayanthi" + fileSeparator + "neuertest.txt");
        System.out.println(fileSeparator);

        try {
            if (file.createNewFile()){
                System.out.println(file.getAbsolutePath() + " filename : " + file.getName());
                System.out.println("New File is created");
            }
            else {
                System.out.println("File already exists");
                System.out.println(file.getAbsolutePath() + " filename : " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
