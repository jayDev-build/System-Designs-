package SplitWisePractice2.Strategy;

import SplitWisePractice2.Entities.Split;
import SplitWisePractice2.Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> split(double amount, List<User> participants, Map<User, Double> metadata) {
        List<Split> splitList = new ArrayList<>();
        double share = amount / participants.size();
        participants.forEach(user -> splitList.add(new Split(user, share)));
        return splitList;
    }
}
