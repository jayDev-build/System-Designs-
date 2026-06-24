package SplitWisePractice2.Strategy;

import SplitWisePractice2.Entities.Split;
import SplitWisePractice2.Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> split(double amount, List<User> participants, Map<User, Double> metadata) {
        List<Split> splitList = new ArrayList<>();
        double percentageSum = metadata.values().stream().mapToDouble(v -> v).sum();
        if(percentageSum != 100.0) {
            throw new IllegalArgumentException("Percentage Sum Not Equals to 100");
        }

        for (Map.Entry<User, Double> entry: metadata.entrySet()){
                splitList.add(new Split(entry.getKey(), entry.getValue() * amount / 100));
        }

        return splitList;
    }
}
