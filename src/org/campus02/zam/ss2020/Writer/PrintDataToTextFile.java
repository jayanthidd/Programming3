package org.campus02.zam.ss2020.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintDataToTextFile {
    public static void main(String[] args) throws IOException {
        File file = new File ("myownfile.txt");

        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("First Line");
        printWriter.println("Second Line");
        printWriter.append("c");

        printWriter.flush();
        printWriter.close();
        System.out.println("Fertig");
    }
}
