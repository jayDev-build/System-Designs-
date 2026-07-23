package Uber.Models.Products;

import Uber.Enums.ProductType;

public class UberGo extends Product {
    public UberGo() {
        super("UberGo", ProductType.UBER_GO);
    }

    @Override
    public double getBaseRate() {
        return 20;
    }

    @Override
    public double getPerKmRate() {
        return 10;
    }

    @Override
    public double getPerMinRate() {
        return 20;
    }
}
