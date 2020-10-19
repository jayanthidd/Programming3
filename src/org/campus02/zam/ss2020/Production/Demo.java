package org.campus02.zam.ss2020.Production;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        ProductManager pm = new ProductManager();
        String path = "Production.txt";
        Product p1 = new Product("Toothpaste", 2.5, "Toiletries");
        Product p2 = new Product("Shampoo", 4.75, "Toiletries");
        pm.addProduct(p1);
        pm.addProduct(p2);
        pm.saveToFile(path);
        pm.readFromFile(path);
    }
}
