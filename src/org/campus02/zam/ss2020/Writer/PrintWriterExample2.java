package org.campus02.zam.ss2020.Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.DoubleToIntFunction;

public class PrintWriterExample2 {
    public static void main(String[] args) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(("output.txt")));
            int age = 40;
            output.printf("I am %d years old", age);
            output.flush();
            System.out.println(output.checkError());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
