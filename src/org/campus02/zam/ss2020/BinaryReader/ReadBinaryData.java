package org.campus02.zam.ss2020.BinaryReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryData {
    // this does not work for me
    public static void main(String[] args) throws IOException {
        File file = new File("Noten.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        int byteRead;
        int count = 0;
        while ((byteRead = fileInputStream.read())!= -1) {
            char[] ch = Character.toChars(byteRead);
            System.out.println(ch[0]);
            count++;
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
