package org.campus02.zam.ss2020.practice.productionbinary;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct (Product p) {
        products.add(p);
    }

    public void save(String path){
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            for (Product p : products){
                objectOutputStream.writeObject(p);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void load(String path) {
        ObjectInputStream objectInputStream = null;
        ArrayList<Product> newproducts = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            boolean cont = true;
            Product p = null;
            while (cont){
                try {
                    p = (Product) objectInputStream.readObject();
                    if (p != null) {
                        newproducts.add(p);
                        System.out.println(p);
                    } else {
                        cont = false;
                    }
                } catch (EOFException ex){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
