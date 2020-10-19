package org.campus02.zam.ss2020.practice2.serializableproducts;

import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private double price;
    private String productCategory;

    public Product(String productName, double price, String productCategory) {
        this.productName = productName;
        this.price = price;
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
