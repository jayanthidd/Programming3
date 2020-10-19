package org.campus02.zam.ss2020.Reader;

import java.io.File;

public class ListSubDirectories {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\nxf49434\\Downloads\\Jayanthi\\jay");
        listDIrectories(dir.getAbsolutePath());
    }
    public static void listDIrectories(String path){
        File dir = new File(path);
        File[] list = dir.listFiles();
        System.out.println("Original Path : " + dir.getAbsolutePath());

        if (list == null) {
            return;
        }
        for (File f : list) {
            if (f.isDirectory()) {
                listDIrectories((f.getAbsolutePath()));
                System.out.println("Directory : " + f.getAbsolutePath());
            }
            else {
                System.out.println("File : " + f.getAbsolutePath());
            }
        }
    }
}
