package SplitWise.Repository;

import SplitWise.Entities.Group;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepo {

    Map<String, Group> groupMap = new HashMap<>();

    public void addGroup(String id, Group group){
        groupMap.put(id, group);
    }
    public Group get(String id){
        return groupMap.get(id);
    }
}
