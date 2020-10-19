package org.campus02.zam.ss2020.practice.productionbinary;

public class Demo {
    public static void main(String[] args) {
        Product paste = new Product("Toothpaste", 2, "Toiletries");
        Product soap = new Product("Bodywash", 4.99, "Toiletries");

        ProductManager pm = new ProductManager();

        pm.addProduct(paste);
        pm.addProduct(soap);

        pm.save("product.dat");
        pm.load("product.dat");
    }
}
