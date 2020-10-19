package org.campus02.zam.ss2020.practice2.serializableproducts;

import javax.swing.border.Border;
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

    public void load (String path) {
        ObjectInputStream objectInputStream = null;
        products.removeAll(products);
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
            Boolean cont = true;
            while(cont){

                try{
                    Product p = (Product)objectInputStream.readObject();
                    System.out.println(p.toString());
                    if (p!=null) {
                        products.add(p);
                    } else {
                        cont = false;
                    }
                } catch (EOFException e){
                    System.out.println("No more records found");
                    break;
                }
            }
            System.out.println(products.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
