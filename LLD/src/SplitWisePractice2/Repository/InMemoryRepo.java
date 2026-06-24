package SplitWisePractice2.Repository;

import SplitWisePractice2.Entities.Group;

import java.util.HashMap;

public class InMemoryRepo {

    private HashMap<String, Group> groupMap;

    public InMemoryRepo(){
        groupMap = new HashMap<>();
    }

    public void addGroup(String groupId, Group group){
        groupMap.putIfAbsent(groupId, group);
    }

    public Group getGroup(String groupId){
        return groupMap.get(groupId);
    }
}
