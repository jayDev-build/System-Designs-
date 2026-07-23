package Uber.Factory;

import Uber.Enums.PricingStrategyType;
import Uber.Strategy.Pricing.LocationBasedPricingStrategy;
import Uber.Strategy.Pricing.NightBasedPricingStrategy;
import Uber.Strategy.Pricing.PricingStrategy;

public class PricingFactory {

    public PricingStrategy createPricingStrategy(PricingStrategyType type) {
        switch (type) {
            case PricingStrategyType.LOCATION_BASED:
                return new LocationBasedPricingStrategy();
            case PricingStrategyType.NIGHT_BASED:
                return new NightBasedPricingStrategy();
            default:
                break;
        }
        return null;
    }
}
