package org.campus02.zam.ss2020.practice.product;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public void saveToFile(String path){
        BufferedWriter bufferedWriter = null;

        try{
            bufferedWriter = new BufferedWriter(new FileWriter(path));

            for(Product p : products){
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFromFile(String path){
        BufferedReader bufferedReader = null;
        OutputStreamWriter outputStreamWriter = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(path));
            outputStreamWriter = new OutputStreamWriter(System.out);

            String line;
            while((line = bufferedReader.readLine())!=null){
                outputStreamWriter.write(line);
                outputStreamWriter.flush();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                outputStreamWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
