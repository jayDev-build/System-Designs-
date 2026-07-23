package Uber.Factory;

import Uber.Models.Products.Product;
import Uber.Enums.ProductType;
import Uber.Models.Products.UberGo;
import Uber.Models.Products.UberX;
import Uber.Models.Products.UberAuto;

public class ProductFactory {

    public Product getProduct(ProductType productType) {
        switch (productType) {
            case UBER_GO:
                return new UberGo();
            case UBER_X:
                return new UberX();
            case UBER_AUTO:
                return new UberAuto();
            default:
                throw new IllegalArgumentException("Unknown product type: " + productType);
        }
    }

}
