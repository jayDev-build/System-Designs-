package ParkingLot.Factory;

import ParkingLot.Enums.PricingStrategyType;
import ParkingLot.Strategy.Pricing.EventBasedPricing;
import ParkingLot.Strategy.Pricing.TimeBasedPricing;
import ParkingLot.Strategy.Pricing.PricingStrategy;

public class PricingStrategyFactory {
    public PricingStrategy get(PricingStrategyType strategy){
        return switch (strategy){
            case PricingStrategyType.TIMEBASEPRICING -> new TimeBasedPricing();
            case PricingStrategyType.EVENTBASEDPRICING -> new EventBasedPricing();
        };
    }
}
