package org.campus02.zam.ss2020.networks.readingfromurl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromURL {
    public static void main(String[] args) {
        BufferedReader userInput = null;
        BufferedReader bufferedReader = null;

        try {
            System.out.println("Input your URL");
            userInput = new BufferedReader(new InputStreamReader(System.in));
            String website = userInput.readLine();
            URL url = new URL(website);

            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        } finally {
            try {
                userInput.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
