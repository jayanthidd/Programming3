package org.campus02.zam.ss2020.practice.threadconsoleandsync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static String consoleEntry(){
        BufferedReader bufferedReader = null;

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String entry = null;
        try {
            entry = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entry;
    }
}
