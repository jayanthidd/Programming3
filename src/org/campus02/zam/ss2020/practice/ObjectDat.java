package org.campus02.zam.ss2020.practice;

import java.io.*;

public class ObjectDat {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            String str = "Hallo Welt";
            String str2 = "The world is beautiful";

            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));

            objectOutputStream.writeObject(str);
            objectOutputStream.writeObject(str2);
            objectOutputStream.flush();

            Object read = null;
            while (objectInputStream.readObject()!=null);
                System.out.println((String)objectInputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
