package ParkingLot.Payment;

import ParkingLot.Models.Ticket;
import ParkingLot.Strategy.PaymentStrategy;

public class PaymentProcessor {

    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy){
        this.strategy = paymentStrategy;
    }

    public boolean pay(Ticket ticket, Double amount){
        return strategy.pay(ticket, amount);
    }
}
