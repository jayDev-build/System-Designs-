package Uber.Models;

public class Rider {
    public String id;
    public String name;
    public Location currLocation;

    public Rider(String id, String name, Location currLocation) {
        this.id = id;
        this.name = name;
        this.currLocation = currLocation;
    }
}
