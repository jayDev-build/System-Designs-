package Uber.Factory;

import Uber.Enums.DriverMatchingStrategyType;
import Uber.Strategy.DriverMatching.DriverLocationStrategy;
import Uber.Strategy.DriverMatching.DriverMatchingStrategy;
import Uber.Strategy.DriverMatching.DriverRatingStrategy;

public class DriverFactory {
    public DriverMatchingStrategy createDriverMatchingStrategy(DriverMatchingStrategyType type) {
        switch (type) {
            case DriverMatchingStrategyType.LOCATION_BASED:
                return new DriverLocationStrategy();
            case DriverMatchingStrategyType.RATING_BASED:
                return new DriverRatingStrategy();
            default:
                return new DriverLocationStrategy();
        }
    }
}
