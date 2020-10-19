package org.campus02.zam.ss2020.practice.addressbuch1;

import java.io.*;
import java.util.ArrayList;

public class AddressManager {
    private ArrayList<Address> addresses;

    public AddressManager() {
        this.addresses = new ArrayList<>();
    }

    public void add(Address a){
        addresses.add(a);
    }

    public void exportToCsv(String path, String separator) throws AddressExportException, AddressExportFileAlreadyExistsException {
        File file = new File(path);
        if(file.exists()){
            throw new AddressExportFileAlreadyExistsException("File already exists");
        }
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Address a : getAddresses()){
                bufferedWriter.write(a.getFirstName()+separator+a.getLastName()+separator+a.getMobileNumber()+separator+a.getEmail());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new AddressExportException();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadFromCsv(String path, String separator) throws AddressLoadException, AddressLoadWrongFormatException {
        addresses.removeAll(addresses);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String address;
            while ((address = bufferedReader.readLine())!=null){
                System.out.println(address);
                String[] split = address.split(separator);
                if (split.length!=4){
                    throw new AddressLoadWrongFormatException();
                }
                Address a = new Address(split[0], split[1],split[2], split[3]);
                addresses.add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new AddressLoadException();
        }
    }
    public ArrayList<Address> getAddresses() {
        return addresses;
    }
}
