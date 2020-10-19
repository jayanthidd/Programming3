package org.campus02.zam.ss2020.BinaryWriter;

import java.io.*;

public class BinaryWritewithanX {
    public static void main(String[] args) throws IOException {
        File file = new File("X.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        char c;
        while (true) {
            c = (char) System.in.read();
            if (c =='X' || c == 'x') {
                System.out.println("Es kam ein x");
                break;
            }
            fileOutputStream.write(c);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
