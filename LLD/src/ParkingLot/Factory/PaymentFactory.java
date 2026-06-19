package ParkingLot.Factory;

import ParkingLot.Enums.PaymentType;
import ParkingLot.Strategy.Payment.CardPayment;
import ParkingLot.Strategy.Payment.CashPayment;
import ParkingLot.Strategy.Payment.PaymentStrategy;

public class PaymentFactory {

    public PaymentStrategy getPaymentStrategy(PaymentType paymentType){
        return switch (paymentType){
            case PaymentType.CARD -> new CardPayment();
            case PaymentType.CASH -> new CashPayment();
        };
    }
}
