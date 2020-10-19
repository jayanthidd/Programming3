package org.campus02.zam.ss2020.practice.addressbuch;

public class AddressExportException extends Exception{
    public AddressExportException() {
        System.out.println("The addresses could not be exported");
    }
}
