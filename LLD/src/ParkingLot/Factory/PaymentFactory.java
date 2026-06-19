package ParkingLot.Factory;

import ParkingLot.Enums.PaymentType;
import ParkingLot.Payment.CardPayment;
import ParkingLot.Payment.CashPayment;
import ParkingLot.Strategy.PaymentStrategy;

public class PaymentFactory {

    public PaymentStrategy getPaymentStrategy(PaymentType paymentType){
        return switch (paymentType){
            case PaymentType.CARD -> new CardPayment();
            case PaymentType.CASH -> new CashPayment();
        };
    }
}
