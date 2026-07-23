package Uber.Models.Products;

import Uber.Enums.ProductType;

public class UberAuto extends Product {
    public UberAuto() {
        super("UberAuto", ProductType.UBER_AUTO);
    }

    @Override
    public double getBaseRate() {
        return 10;
    }

    @Override
    public double getPerKmRate() {
        return 5;
    }

    @Override
    public double getPerMinRate() {
        return 2;
    }
}
