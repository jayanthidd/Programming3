package org.campus02.zam.ss2020.Writer;

import java.io.*;
import java.util.Scanner;

public class TextOutputNoten {
    public static void main(String[] args) throws IOException {
        File file = new File ("Noten.txt");

        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Subject and Grade : ");
            String line = br.readLine();
            if(line.contains("STOP") || line.contains("stop")){
                break;
            }
            printWriter.println(line);
        }
        printWriter.flush();
        printWriter.close();

        br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine())!=null) {
            System.out.println(line);
        }
    }
}
