package Uber.Models.Products;

import Uber.Enums.ProductType;

public class UberX extends Product {
    public UberX() {
        super("UberShare", ProductType.UBER_X);
    }

    @Override
    public double getBaseRate() {
        return 0;
    }

    @Override
    public double getPerKmRate() {
        return 5;
    }

    @Override
    public double getPerMinRate() {
        return 5;
    }
}
