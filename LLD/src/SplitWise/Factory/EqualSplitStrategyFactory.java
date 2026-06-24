package SplitWise.Factory;

import SplitWise.Strategy.EqualSplitStrategy;
import SplitWise.Strategy.SplitStrategy;

public class EqualSplitStrategyFactory implements SplitStrategyFactory{
    @Override
    public SplitStrategy createSplitStrategy() {
        return new EqualSplitStrategy();
    }
}
