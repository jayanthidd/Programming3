package org.campus02.zam.ss2020.practice.product;

public class Demo {
    public static void main(String[] args) {
        Product p1 = new Product("Table", 200, "Furniture");
        Product p2 = new Product("Chair", 95, "Furniture");

        ProductManager productManager = new ProductManager();
        productManager.addProduct(p1);
        productManager.addProduct(p2);

        productManager.saveToFile("url.txt");
        productManager.readFromFile("url.txt");
    }
}
