package org.campus02.zam.ss2020.addressbook;

import java.io.*;
import java.util.ArrayList;

public class AddressManager {
    ArrayList<Address> addressList;

    public AddressManager() {
        this.addressList = new ArrayList<>();
    }

    public void addAddress(Address address) {
        addressList.add(address);
    }

    public void exportToCsv (String path, String separator) throws AddressExportFileAlreadyExistsException, AddressExportException {
        File file = new File(path);
        if (file.exists()){
            throw new AddressExportFileAlreadyExistsException();
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));

            for (Address a : addressList) {
                String str = a.toString().replaceAll(",", separator);
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException ex){
            throw new AddressExportException();
        } finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void loadFromCsv(String path, String separator) throws AddressLoadWrongFromatException, AddressLoadException {
        File file = new File(path);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            addressList.removeAll(addressList);

            String str;
            while ((str=br.readLine())!=null){
                String[] address = str.split(separator);
                if (address.length!=4){
                    throw new AddressLoadWrongFromatException();
                }
                addressList.add(new Address(address[0], address[1], address[2], address[3]));
            }
            System.out.println(addressList.toString());
        } catch (IOException ex){
            ex.printStackTrace();
            throw new AddressLoadException();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
