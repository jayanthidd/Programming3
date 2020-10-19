package org.campus02.zam.ss2020.unicode;

import java.io.*;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class TextFileWithUnicode {
    public static void main(String[] args) {
        // UTF_8 is sent as a parameter for the outputstreamwriter
        // ISO_8859_1 does not have the umlaut
        writeFile("umlaut.txt", UTF_8);
        readFile("umlaut.txt", UTF_8);

        writeFile("umlaut.txt", ISO_8859_1);
        readFile("umlaut.txt", ISO_8859_1);

    }

    public static void writeFile (String path, Charset encoding) {
        File file = new File (path);
        PrintWriter printWriter = null;
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, encoding);
            printWriter = new PrintWriter(outputStreamWriter);
            printWriter.println("Köche machen Müsli Äpfel");

        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            if (printWriter!=null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
    public static void readFile(String path, Charset enoding) {
        File file = new File(path);
        BufferedReader br = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, enoding);
            br = new BufferedReader(inputStreamReader);
            String str;
            while ((str=br.readLine())!=null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
