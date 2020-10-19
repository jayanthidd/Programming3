package org.campus02.zam.ss2020.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class UeReadSystemInput {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine())!= null) {
            if (line.contains("stop")) {
                break;
            }
            System.out.println(line);
        }
        br.close();
    }
}
