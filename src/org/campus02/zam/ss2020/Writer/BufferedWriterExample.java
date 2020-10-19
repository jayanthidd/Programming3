package org.campus02.zam.ss2020.Writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("bufferedwriter.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(file);

        String data = "das ist ein text";
        bufferedWriter.write(data);
        bufferedWriter.newLine();
        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
