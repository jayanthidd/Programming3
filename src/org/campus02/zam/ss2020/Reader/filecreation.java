package org.campus02.zam.ss2020.Reader;

import java.io.File;
import java.io.IOException;

public class filecreation {
    public static void main(String[] args) {
        File file = new File("umlaute.txt");

        checkFile(file);
    }
    public static void checkFile (File f) {
        try {
            if (f.createNewFile()){
                System.out.println("File was created!");
            }
            else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The name of the file is : " + f.getName());
        System.out.println("The Parent Directory is : " + f.getParent());
        System.out.println("The path to the file : " + f.getAbsolutePath());
        System.out.println("This file is a directory : " + f.isDirectory());
        System.out.println("This is a file : " + f.isFile());
        System.out.println("This file is readable : " + f.canRead());
        System.out.println("This file is writeable : " + f.canWrite());
        System.out.println("The size of the file is : " + f.length());
        ;
        /*
Uebung:

Eine Methode, welche ein File als Parameter hat.
    Methode soll folgende Attribute des Files in die Console ausgeben:
    - Does this file exist?
    - Name of the File
    - Parent Directory of the File
    - Path to this File
    - Is this a directory?
    - Is this a file?
    - Is this file readable?
    - Is this File writeable

 */


    }
}
