package Uber.Service;

import Uber.Models.Fare;
import Uber.Models.Location;
import Uber.Models.Products.Product;
import Uber.Repository.FareRepository;
import Uber.Strategy.Pricing.PricingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FareEstimationService {

    private final FareRepository fareRepository;
    private final PricingStrategy pricingStrategy;

    public FareEstimationService(FareRepository fareRepository, PricingStrategy pricingStrategy) {
        this.fareRepository = fareRepository;
        this.pricingStrategy = pricingStrategy;
    }

    public Map<Product, Double> getFareEstimates(List<Product> products, Location start, Location destination) {
        Map<Product, Double> estimatePrice = new HashMap<>();

        double distance = start.distanceTo(destination);

        int time = (int) (distance * 2);

        for (Product p : products) {
            double price = calculateFare(p, (int) distance, time);
            price += pricingStrategy.calculateFarePrice(start, destination);
            price = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
            estimatePrice.put(p, price);
        }
        return estimatePrice;
    }

    public Fare creteFare(String riderId, Product product, Location start, Location destination) {
        double distance = start.distanceTo(destination);

        int time = (int) (distance * 2);
        double price = calculateFare(product, (int) distance, time);
        price += pricingStrategy.calculateFarePrice(start, destination);
        price = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP).doubleValue();

        Fare fare = new Fare(product, start, destination, price);

        fareRepository.save(riderId, fare);

        return fare;
    }

    public double calculateFare(Product product, int distance, int time) {
        double price = product.getBaseRate()
                + distance * product.getPerKmRate()
                + time * product.getPerMinRate();

        return price;
    }

}