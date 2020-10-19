package org.campus02.zam.ss2020.practice.addressbuch;

public class Demo {
    public static void main(String[] args) {
        Address a = new Address("Bill", "Clinton", "00123", "bill@clinton.com");
        Address b = new Address("Barack", "Obama", "0124", "barack@obama.com");

        AddressManager am = new AddressManager();

        am.addAddress(b);
        am.addAddress(a);

        try {
            am.exportToCsv("addressbook.csv", ",");
        } catch (AddressLoadException e) {
            e.printStackTrace();
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            am.loadFromCsv("addressbook.csv", ",");
        } catch (AddressLoadException e) {
            e.printStackTrace();
        } catch (AddressLoadWrongFormatException e) {
            e.printStackTrace();
        }
    }
}
