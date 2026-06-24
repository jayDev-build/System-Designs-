package SplitWisePractice2.Factory;

import SplitWisePractice2.Enums.SplitStrategyType;
import SplitWisePractice2.Strategy.EqualSplitStrategy;
import SplitWisePractice2.Strategy.PercentageSplitStrategy;
import SplitWisePractice2.Strategy.SplitStrategy;

public class SplitStrategyFactory {

    public SplitStrategy createSplitStrategy(SplitStrategyType type){
        return switch (type){
            case EQUAL -> new EqualSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
        };
    }
}
