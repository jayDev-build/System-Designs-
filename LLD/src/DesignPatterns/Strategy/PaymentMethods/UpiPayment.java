package DesignPatterns.Strategy.PaymentMethods;

import DesignPatterns.Strategy.Strategy.PaymentStrategy;

public class UpiPayment implements PaymentStrategy {

    @Override
    public void processPayemnt() {
        System.out.println("UPI payment method.........");
    }
}
