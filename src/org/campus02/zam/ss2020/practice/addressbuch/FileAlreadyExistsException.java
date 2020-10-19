package org.campus02.zam.ss2020.practice.addressbuch;

public class FileAlreadyExistsException extends Exception {
    public FileAlreadyExistsException() {
        System.out.println("This file already exists");
    }
}
