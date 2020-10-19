package org.campus02.zam.ss2020.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExampleCharByChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("umlaute.txt"));
        int c;
        while ((c = br.read())!=-1) {
            char character = (char)c;
            System.out.println(c + "-" + character);
        }
    }
}
