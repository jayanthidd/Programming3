package org.campus02.zam.ss2020.addressbook;

public class AddressExportFileAlreadyExistsException extends Exception {
    public AddressExportFileAlreadyExistsException() {
        super("This file already exists");
    }

}
