package Uber.Models.Products;

import Uber.Enums.ProductType;

public abstract class Product {
    public String id;
    public ProductType productType;

    public Product(String id, ProductType productType) {
        this.id = id;
        this.productType = productType;
    }

    public abstract double getBaseRate();

    public abstract double getPerKmRate();

    public abstract double getPerMinRate();

}
