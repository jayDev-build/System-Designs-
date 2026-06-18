package Strategy;

import Strategy.PaymentMethods.CreditCardPayment;
import Strategy.PaymentMethods.PayPalPayment;
import Strategy.PaymentMethods.UpiPayment;
import Strategy.Strategy.PaymentStrategy;

public class Client {
    public static void main(String[] args) {
        PaymentStrategy paymentStrategy1 = new CreditCardPayment();
        PaymentStrategy paymentStrategy2 = new UpiPayment();
        PaymentStrategy paymentStrategy3 = new PayPalPayment();

        PaymentProcessor paymentProcessor1 = new PaymentProcessor(paymentStrategy1);
        PaymentProcessor paymentProcessor2 = new PaymentProcessor(paymentStrategy2);
        PaymentProcessor paymentProcessor3 = new PaymentProcessor(paymentStrategy3);

        paymentProcessor1.processPayment();
        paymentProcessor2.processPayment();
        paymentProcessor3.processPayment();


    }
}
