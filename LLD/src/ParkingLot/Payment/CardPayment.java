package ParkingLot.Payment;

import ParkingLot.Models.Ticket;
import ParkingLot.Strategy.PaymentStrategy;

public class CardPayment extends PaymentStrategy {

    @Override
    public boolean pay(Ticket ticket, Double amount) {
        System.out.println("Paying Amount Via Card ..........");
        return true;
    }
}
