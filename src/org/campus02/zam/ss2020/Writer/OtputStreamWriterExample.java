package org.campus02.zam.ss2020.Writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OtputStreamWriterExample {
    public static void main(String[] args) throws IOException {
        String data = "example";
        FileOutputStream file = new FileOutputStream("output.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);

        outputStreamWriter.write(data);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
}
