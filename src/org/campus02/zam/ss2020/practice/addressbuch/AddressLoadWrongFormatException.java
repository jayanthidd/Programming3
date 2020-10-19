package org.campus02.zam.ss2020.practice.addressbuch;

public class AddressLoadWrongFormatException extends Exception {
    public AddressLoadWrongFormatException(String message) {
        super(message);
    }

    public AddressLoadWrongFormatException() {
        System.out.println("The format of the address is incorrect");
    }
}
