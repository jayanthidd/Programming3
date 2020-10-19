package org.campus02.zam.ss2020.practice.addressbuch1;

public class AddressExportException extends Exception {
    public AddressExportException() {
        System.out.println("Address was not exported");
    }
}
