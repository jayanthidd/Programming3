package org.campus02.zam.ss2020.practice.addressbuch;

import java.io.*;
import java.util.ArrayList;

public class AddressManager {
    private ArrayList<Address> addressList;

    public AddressManager() {
        this.addressList = new ArrayList<>();
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void addAddress (Address a){
        addressList.add(a);
    }

    public void exportToCsv (String path, String separator) throws AddressLoadException, FileAlreadyExistsException {
        BufferedWriter bufferedWriter = null;
        File file = new File(path);
        if (file.exists()){
            throw new FileAlreadyExistsException();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));

            for(Address a : getAddressList()){
                bufferedWriter.write(a.getFirstName()+separator+a.getLastName()+separator+a.getMobileNumber()+separator+a.getEmail());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new AddressLoadException();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadFromCsv(String path, String separator) throws AddressLoadException, AddressLoadWrongFormatException {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String read;
            String[] address;
            addressList.removeAll(addressList);

            while ((read = bufferedReader.readLine())!=null){
                address = read.split(separator);
                if (address.length!=4){
                    throw new AddressLoadWrongFormatException();
                }
                addressList.add(new Address(address[0], address[1], address[2], address[3]));
            }
            for (Address a : addressList){
                System.out.println(a.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new AddressLoadException();
        }
    }
}
