package org.campus02.zam.ss2020.Reader;

import java.io.File;

public class DirectoryContent {
    public static void main(String[] args) {
    /*
    Write a method (+takes a file as parameter. (Directory Path)),
    which lists all filenames of a a given directory.
    Tip: Check if Directory exists + if given File is a directory
    to prevent failures. Write a message to console if this is the case.
    */
    File dir = new File("C:\\Users\\nxf49434\\Downloads\\Jayanthi");
    printContentofDirectory(dir);
    }

    public static void printContentofDirectory(File d) {
        if (d.exists() && d.isDirectory()){
                long size = 0;
                File[] list = d.listFiles();
                for (File f : list) {
                    if (f.isDirectory()){
                        System.out.println(f.getName() + " : This is a directory");
                    }
                    else {
                        size += f.length();
                        System.out.println(f.getName() + " : " + f.length()/1000 + "kb");
                    }
                }
            System.out.println("The size of all files in this directory is : " + size / 1000 + "kb");
        }
        else {
            System.out.println("This directory / file does not exist or is not a directory!");
        }
    }
}
