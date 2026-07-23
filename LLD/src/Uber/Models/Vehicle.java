package Uber.Models;

import java.util.ArrayList;
import java.util.List;

import Uber.Models.Products.Product;

public class Vehicle {
    public String number;
    public List<Product> supportedProducts;

    public Vehicle(String number) {
        this.number = number;
        supportedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        supportedProducts.add(product);
    }

    public List<Product> getProducts() {
        return supportedProducts;
    }
}
