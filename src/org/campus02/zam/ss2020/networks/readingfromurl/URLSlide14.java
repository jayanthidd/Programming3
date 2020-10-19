package org.campus02.zam.ss2020.networks.readingfromurl;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLSlide14 {
    public static void main(String[] args) {
        File file = new File("url.txt");
        BufferedReader readfile = null;
        BufferedReader bufferedReader = null;
        BufferedWriter writeFile = null;

        try {
            readfile = new BufferedReader(new FileReader(file));
            String path = readfile.readLine();
            URL url = new URL(path);
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            writeFile = new BufferedWriter(new FileWriter("content.html"));
            String content;
            while ((content = bufferedReader.readLine()) != null) {
                writeFile.write(content);
                writeFile.newLine();
                writeFile.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                readfile.close();
                writeFile.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}