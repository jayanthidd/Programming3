package org.campus02.zam.ss2020.Writer;

import java.io.StringWriter;

public class StringWriterExample {
    public static void main(String[] args) {
        String data = "This is the text in the string";

        StringWriter stringWriter = new StringWriter();

        stringWriter.write(data);
    }
}
