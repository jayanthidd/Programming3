package org.campus02.zam.ss2020.networks.readingfromurl;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromURL2 {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            URL url = new URL("https://www.wetter.at/");
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            String line;
            while((line = bufferedReader.readLine())!= null) {
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
