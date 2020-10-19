package org.campus02.zam.ss2020.practice.addressbuch;

public class AddressLoadException extends Exception{
    public AddressLoadException() {
        System.out.println("The addresses could not be loaded");
    }
}
