package Strategy.PaymentMethods;

import Strategy.Strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayemnt() {
        System.out.println("Credit Card Payment Method.....");
    }
}
