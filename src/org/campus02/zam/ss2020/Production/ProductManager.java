package org.campus02.zam.ss2020.Production;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void saveToFile (String path){
        File file = new File(path);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter( new FileWriter(file));
            for (Product p : products) {
                bufferedWriter.write(p.toString());
               // bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFromFile(String path) {
        BufferedReader br = null;
        try {
            File file = new File (path);
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine())!=null) {
                System.out.println(line);
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
