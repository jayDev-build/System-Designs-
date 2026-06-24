package SplitWise.Strategy;

import SplitWise.Entities.Split;
import SplitWise.Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> split(double amount, List<User> userList, Map<User, Double> metaData) {
        double percentageSum = metaData.values().stream().mapToDouble(v -> v).sum();
        if(percentageSum != 100) {
            throw new IllegalArgumentException("Percentage Sum Not Equals to 100");
        }
        List<Split> splitList = new ArrayList<>();
        for(Map.Entry<User, Double> entry : metaData.entrySet()){
            splitList.add(new Split(entry.getKey(), entry.getValue() * amount / 100));
        }
        return splitList;
    }
}
