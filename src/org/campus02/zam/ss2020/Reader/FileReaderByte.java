package org.campus02.zam.ss2020.Reader;

import java.io.FileReader;

public class FileReaderByte {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("umlaute.txt");
        int i;
        while ((i = fr.read())!=-1) {
            System.out.print((char)i);
        }
        fr.close();
    }
}
