package org.campus02.zam.ss2020.practice.serializableproducts;

public class Demo {
    public static void main(String[] args) {
        Product p = new Product("A", 25, "food");
        Product p1 = new Product("B", 3, "food");

        ProductManager pm = new ProductManager();

        pm.add(p);
        pm.add(p1);

        pm.save("products.dat");
        pm.load("products.dat");

    }
}
