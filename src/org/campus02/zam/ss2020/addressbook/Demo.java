package org.campus02.zam.ss2020.addressbook;

public class Demo {
    public static void main(String[] args) throws AddressLoadWrongFromatException, AddressLoadException {
        AddressManager am = new AddressManager();
        Address a1 = new Address("Jon", "Doe", "0664", "john.doe@johndoe.com");
        Address a2 = new Address("Apple", "Smith", "0664", "apple.smith@applesmith.com");

        am.addAddress(a1);
        am.addAddress(a2);

        try {
            am.exportToCsv("addressbook.csv", ";");
        } catch (AddressExportFileAlreadyExistsException | AddressExportException e) {
            e.printStackTrace();
        }
        am.loadFromCsv("addressbook.csv", ";");

        Address a3 = new Address( "Cathy","Park", "0956", "cathy.park@gmail.com");
        am.addAddress(a3);

        try {
            am.exportToCsv("addressbook.csv", ";");
        } catch (AddressExportFileAlreadyExistsException | AddressExportException e) {
            e.printStackTrace();
        }
        am.loadFromCsv("addressbook.csv", ";");
    }
}
