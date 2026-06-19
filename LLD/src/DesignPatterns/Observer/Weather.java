package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject{
    private String temperature;
    private List<Observer> observers = new ArrayList<>();

    public void updateTemperature(String temperature){
        this.temperature = temperature;
        notifyObserver();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer obs : observers){
            obs.setTemperature(temperature);
        }
    }
}
