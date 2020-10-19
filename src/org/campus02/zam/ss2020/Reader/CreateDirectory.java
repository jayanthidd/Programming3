package org.campus02.zam.ss2020.Reader;

import java.io.File;
import java.util.Scanner;

public class CreateDirectory {
    public static void main(String[] args) {
        System.out.print("Enter the path to create a directory : ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        System.out.print("Enter the name of the desired directory : ");
        path = path + "\\" + scanner.next();

        File file = new File(path);
        boolean created = file.mkdirs();//mkdir creates a directory
        if (created) {
            System.out.println("Directory was created!");
            System.out.println(path);
        }
        else {
            System.out.println("Not a directory!");
        }
    }
}
