package org.campus02.zam.ss2020.BinaryWriter;

import java.io.*;

public class BinaryIoUebung {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String object = "Hallo Welt";
        byte[] b = {'e','x','a','m','p','l','e'};
        try {
            File file = new File("hallowelt.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

            objectOutputStream.writeObject(object);
            objectOutputStream.writeObject(b);
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

            System.out.println((String) objectInputStream.readObject());
            byte[] read = (byte[]) objectInputStream.readObject();
            String s2 = new String(read);
            System.out.println(s2);
            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
