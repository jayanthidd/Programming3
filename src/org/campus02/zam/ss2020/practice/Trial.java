package org.campus02.zam.ss2020.practice;

import java.io.*;

public class Trial {
    public static void main(String[] args) throws IOException {
        File file = new File("url.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String content = bufferedReader.readLine();
        while (content!=null) {
            System.out.println(content);
        }
        bufferedReader.close();
    }
}
