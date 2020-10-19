package org.campus02.zam.ss2020.practice.addressbuch1;

public class Demo {
    public static void main(String[] args) {
        Address a = new Address("Tom", "Cruise", "0012", "tom@cruise.com");
        Address b = new Address("Pierce", "Brosnan", "00124", "pierce@bros.com");
        Address c = new Address("John", "Doe", "0125", "john@doe.com");
        Address d = new Address("Cindy", "Crawford", "0129", "cindy@cin.com");

        AddressManager am = new AddressManager();
        am.add(a);
        am.add(b);
        am.add(c);
        am.add(d);

        try {
            am.exportToCsv("addressbook.csv", ",");
            am.loadFromCsv("addressbook.csv", ",");
        }  catch (AddressExportFileAlreadyExistsException e) {
            e.printStackTrace();
        } catch (AddressLoadWrongFormatException e) {
            e.printStackTrace();
        } catch (AddressLoadException e) {
            e.printStackTrace();
        } catch (AddressExportException e) {
            e.printStackTrace();
        }

        for (Address add : am.getAddresses()){
            System.out.println(add);
        }
    }
}
