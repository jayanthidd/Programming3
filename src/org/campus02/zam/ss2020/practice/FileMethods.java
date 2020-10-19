package org.campus02.zam.ss2020.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

public class FileMethods {
    public static void checkFile(File file) {
        System.out.println("Does this file exist? : " + file.exists());
        System.out.println("Name of the File : " + file.getName());
        System.out.println("Parent Directory of the File : " + file.getParent());
        System.out.println("Path to this File : " + file.getPath());
        System.out.println("Is this a directory? : " + file.isDirectory());
        System.out.println("Is this a file? : " + file.isFile());
        System.out.println("Is this file readable? : " + file.canRead());
        System.out.println("Is this file writeable? : " + file.canWrite());
        System.out.println("File Size : " + file.length());
    }

    public static void printFileNames (File file){
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            long total = 0;
            for (File f : files){
                System.out.println(f.getName() + " : " + f.length());
                total += file.length();
            }
            System.out.println("Size of all files in this Directory : " + total);
        }
        else {
            System.out.println("This is not a directory");
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\nxf49434\\Desktop\\Jay\\Application Documents\\Application details.xlsx");
        checkFile(file);
        System.out.println("--------------------------------------");
        File file1 = new File("C:\\Users\\nxf49434\\Desktop\\Jay\\Application Documents");
        printFileNames(file1);
        File file3 = new File("C:\\Users\\nxf49434\\Desktop\\Jay\\Programming3");
        file3.mkdir();
    }

}
