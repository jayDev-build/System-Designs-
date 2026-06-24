package SplitWise.Strategy;

import SplitWise.Entities.Split;
import SplitWise.Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> split(double amount, List<User> userList, Map<User, Double> metaData) {
        double share = amount / userList.size();
        List<Split> splitList = new ArrayList<>();
        for(User user : userList){
            splitList.add(new Split(user, share));
        }
        return splitList;
    }
}
