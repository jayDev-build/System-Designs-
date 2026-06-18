package Strategy.PaymentMethods;

import Strategy.Strategy.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {

    @Override
    public void processPayemnt() {
        System.out.println("PayPal Payment Method..........");
    }
}
