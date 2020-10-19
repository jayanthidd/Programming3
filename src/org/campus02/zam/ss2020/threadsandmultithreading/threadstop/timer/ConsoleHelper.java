package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.timer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleHelper {
    public static String readline() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try{
            return bufferedReader.readLine();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}