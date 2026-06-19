package ParkingLot.Factory;

import ParkingLot.Enums.PricingStrategyType;
import ParkingLot.Pricing.EventBasedPricing;
import ParkingLot.Pricing.TimeBasedPricing;
import ParkingLot.Strategy.PricingStrategy;

public class PricingStrategyFactory {
    public PricingStrategy get(PricingStrategyType strategy){
        return switch (strategy){
            case PricingStrategyType.TIMEBASEPRICING -> new TimeBasedPricing();
            case PricingStrategyType.EVENTBASEDPRICING -> new EventBasedPricing();
        };
    }
}
