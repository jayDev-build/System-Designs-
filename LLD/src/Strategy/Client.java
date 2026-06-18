package Strategy;

import Strategy.PaymentMethods.CreditCardPayment;
import Strategy.PaymentMethods.PayPalPayment;
import Strategy.PaymentMethods.UpiPayment;
import Strategy.Strategy.PaymentStrategy;

public class Client {
    public static void main(String[] args) {
        PaymentStrategy paymentStrategy1 = new CreditCardPayment();
        paymentStrategy1.processPayemnt();

        PaymentStrategy paymentStrategy2 = new UpiPayment();
        paymentStrategy2.processPayemnt();

        PaymentStrategy paymentStrategy3 = new PayPalPayment();
        paymentStrategy3.processPayemnt();

    }
}
