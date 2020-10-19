package org.campus02.zam.ss2020.practice.addressbuch1;

public class AddressLoadException extends Exception {
    public AddressLoadException() {
        System.out.println("Addresses could not be loaded from the Csv file!");
    }
}
