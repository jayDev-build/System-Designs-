package SplitWisePractice2.Strategy;

import SplitWisePractice2.Entities.Split;
import SplitWisePractice2.Entities.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    public List<Split> split(double amount, List<User> participants, Map<User, Double> metadata);
}
