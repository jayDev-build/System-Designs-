package Uber.Models;

import java.util.HashSet;
import java.util.Set;

import Uber.Enums.ProductType;

public class Vehicle {
    public String number;
    public Set<ProductType> supportedProducts;

    public Vehicle(String number) {
        this.number = number;
        supportedProducts = new HashSet<>();
    }

    public void addProduct(ProductType product) {
        supportedProducts.add(product);
    }

    public Set<ProductType> getProducts() {
        return supportedProducts;
    }
}
