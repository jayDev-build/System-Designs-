package Uber.Models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Location {
    public double lat;
    public double lon;

    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double distanceTo(Location dest) {
        double dis = Math.sqrt((this.lat - dest.lat) * (this.lat - dest.lat) +
                (this.lon - dest.lon) * (this.lon - dest.lon));

        dis = BigDecimal.valueOf(dis).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return dis;
    }

    @Override
    public String toString() {
        return "(lat: " + lat + ", lon: " + lon + ")";
    }

}
