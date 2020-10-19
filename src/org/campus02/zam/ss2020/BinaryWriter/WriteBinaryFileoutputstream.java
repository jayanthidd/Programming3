package org.campus02.zam.ss2020.BinaryWriter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinaryFileoutputstream {
    public static void main(String[] args) throws IOException {
        File file = new File("test.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        String outputText = "Hello File - first output";
        for (char c : outputText.toCharArray()) {
            bufferedOutputStream.write(c);
            System.out.println(c);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
