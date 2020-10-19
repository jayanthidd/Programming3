package org.campus02.zam.ss2020.productionbinary;

import javafx.animation.ScaleTransition;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    ArrayList<Product> productList;

    public ProductManager() {
        this.productList  = new ArrayList<>();
    }

    public void add (Product product) {
        productList.add(product);
    }

    public void saveToFile(String path){
        ObjectOutputStream objectOutputStream=null;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            for (Product p : productList) {
                objectOutputStream.writeObject(p);
            }
            objectOutputStream.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFromFile(String path) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
            List<Product> listToPrint = new ArrayList<>();
            boolean cont = true;
            while (cont) {
                try {
                    Product p = (Product) objectInputStream.readObject();
                    System.out.println(p);
                    if (p != null) {
                        listToPrint.add(p);
                    } else {
                        cont = false;
                    }
                } catch (EOFException ex){
                    break;
                }
            }
            for (Product p : listToPrint){
                System.out.println(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
