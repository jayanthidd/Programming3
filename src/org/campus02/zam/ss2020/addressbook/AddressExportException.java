package org.campus02.zam.ss2020.addressbook;

public class AddressExportException extends Exception {
    public AddressExportException() {
        super("The data could not be exported");
    }
}
