package org.campus02.zam.ss2020.practice.serializableproducts;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void add(Product p) {
        products.add(p);
    }

    public void save (String path) {
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            for (Product p : products){
                objectOutputStream.writeObject(p);

            }
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("File saved");
    }
    public void load (String path) {
        ObjectInputStream objectInputStream = null;
        ArrayList<Product> newproducts = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
            Product p;
            while (true){
                try {
                    p = (Product) objectInputStream.readObject();
                    if (p != null) {
                        newproducts.add(p);
                    }else {
                        break;
                    }
                }catch (EOFException ex){
                    break;
                }
            }
            for (Product product : newproducts){
                System.out.println(product.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
