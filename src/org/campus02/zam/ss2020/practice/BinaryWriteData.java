package org.campus02.zam.ss2020.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryWriteData {
    public static void main(String[] args) {
        File file = new File("practice.txt");
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
//        try{
//            fileOutputStream = new FileOutputStream(file);
//            char c;
//            while ((c=(char) System.in.read())!=-1){
//                if (c!='X'){
//                    fileOutputStream.write(c);
//                    fileOutputStream.flush();
//                }else {
//                    System.out.println("You entered an X.  Bye");
//                    return;
//                }
//            }
//
//        }catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        try{
            fileInputStream = new FileInputStream(file);
            char c;
            while ((c=(char)fileInputStream.read())!=-1) {
                System.out.print(c);
            }
        } catch (IOException ex){
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
