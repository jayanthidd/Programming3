package org.campus02.zam.ss2020.BinaryReader;

import java.io.*;

public class ReadBufferedBinaryData {
    public static void main(String[] args) throws IOException {
        File file = new File ("Noten.txt");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        // bufferedinputstream optimises the performance.  Better than fileinputstream
        int byteRead;
        int count = 0;
        while ((byteRead = bis.read())!= -1) {
            //char[] ch = Character.toChars(byteRead);
            System.out.print((char)byteRead);
            count++;
        }
        System.out.println();
        System.out.println(count);
        bis.close();
    }
}
