package Uber.Strategy.DriverMatching;

import Uber.Models.Driver;
import Uber.Models.Location;
import java.util.List;

public class DriverLocationStrategy extends DriverMatchingStrategy{
    
    @Override
    public Driver findDriver(Location location, List<Driver> drivers){
        
        Driver bestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for(Driver d : drivers){
            double distance = d.currLocation.distanceTo(location);
            if(distance < minDistance){
                minDistance = distance;
                bestDriver = d;
            }
        }
        return bestDriver;
    }
}
