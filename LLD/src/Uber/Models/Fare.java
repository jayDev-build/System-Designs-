package Uber.Models;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

import Uber.Models.Products.Product;

public class Fare {
    public String id;
    public Product product;
    public Location source;
    public Location destination;
    public double estimatedFare;
    public Instant createdAt;

    public Fare(Product product, Location start, Location desLocation, double estimatedFare) {
        this.id = java.util.UUID.randomUUID().toString();
        this.product = product;
        this.source = start;
        this.destination = desLocation;
        this.estimatedFare = estimatedFare;
        this.createdAt = java.time.Instant.now();
    }

    @Override
    public String toString() {
        return "[id: " + id + ", Product: " + product.productType.name() + ", source: " + source + ", destination: "
                + destination +
                ", estimatedFare: " + estimatedFare + ", createdAt: "
                + LocalTime.ofInstant(createdAt, ZoneId.of("Asia/Kolkata")) + "]";
    }

}
