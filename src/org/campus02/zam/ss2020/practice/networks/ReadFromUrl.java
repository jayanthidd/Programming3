package org.campus02.zam.ss2020.practice.networks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadFromUrl {
    public static void main(String[] args) {
        System.out.print("Enter the URL : ");
        BufferedReader br = null;
        URL myURL = null;
        BufferedReader brForURL = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            myURL = new URL(br.readLine());

            brForURL = new BufferedReader(new InputStreamReader(myURL.openStream()));

            String line;

            while ((line = brForURL.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                brForURL.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String read;

    }
}
