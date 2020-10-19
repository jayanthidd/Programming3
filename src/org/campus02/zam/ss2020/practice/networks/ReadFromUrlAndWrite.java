package org.campus02.zam.ss2020.practice.networks;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromUrlAndWrite {
    public static void main(String[] args) {
        URL myURL = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            myURL = new URL("https://www.wetter.at/");
            bufferedReader = new BufferedReader(new InputStreamReader(myURL.openStream()));
            bufferedWriter = new BufferedWriter(new FileWriter("content.html"));

            String line;
            while((line=bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
