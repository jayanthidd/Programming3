package org.campus02.zam.ss2020.addressbook;

public class AddressLoadException extends Exception{
    public AddressLoadException() {
        super("Address could not be loaded");
    }
}
