package org.campus02.zam.ss2020.addressbook;

public class AddressLoadWrongFromatException extends Exception {
    public AddressLoadWrongFromatException(String message) {
        super(message);
    }

    public AddressLoadWrongFromatException() {
        System.out.println("Formatting Error");
    }
}
