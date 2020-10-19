package org.campus02.zam.ss2020.practice2.serializableproducts;


public class Demo {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        String path = "binaryproduction.dat";
        Product p1 = new Product("Product1", 1, "Test1");
        Product p2 = new Product("Product2", 2, "Test2");
        productManager.add(p1);
        productManager.add(p2);

        productManager.save(path);
        productManager.load(path);
    }
}
