package org.campus02.zam.ss2020.threadsandmultithreading.threadstop.worker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Scanner;

public class ConsoleHelper {
    public static String readline() {
        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        try{
            return s;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
