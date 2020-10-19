package org.campus02.zam.ss2020.networks.readingfromurl;

import java.io.*;
import java.net.URL;

public class ReadAndWrite {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        BufferedReader readfromURL = null;
        try {
            //step 1 - read from the file url.txt
            bufferedReader = new BufferedReader(new FileReader("url.txt"));
            String website = bufferedReader.readLine();
            //step2 - open the URL connection
            URL url = new URL(website);
            readfromURL = new BufferedReader(new InputStreamReader(url.openStream()));
            //step3.1 - create a file to write the response to.
            File file = new File("content1.html");

            //step 3.2 - write onto the file content1.html
            bufferedWriter = new BufferedWriter(new FileWriter(file));

            String content;
            while ((content = readfromURL.readLine())!=null){
                bufferedWriter.write(content);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                readfromURL.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
