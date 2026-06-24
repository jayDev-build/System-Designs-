package SplitWise.Factory;

import SplitWise.Strategy.PercentageSplitStrategy;
import SplitWise.Strategy.SplitStrategy;

public class PercentageSplitStrategyFactory implements SplitStrategyFactory{
    @Override
    public SplitStrategy createSplitStrategy() {
        return new PercentageSplitStrategy();
    }
}
