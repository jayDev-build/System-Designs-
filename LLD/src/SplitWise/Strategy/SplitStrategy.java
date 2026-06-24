package SplitWise.Strategy;

import SplitWise.Entities.Split;
import SplitWise.Entities.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    public List<Split> split(double amount, List<User> userList, Map<User, Double> metaData);
}
