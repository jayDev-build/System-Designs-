package SnakeAndLadders.Entities;

import SnakeAndLadders.Entities.Obstacle.Obstacle;

public class Cell {
    private final int position;
    public Obstacle obstacle;

    public Cell(int position){
        this.position = position;
    }

    public boolean setObstacle(Obstacle obstacle){
        if(hasObstacle()) return false;
        this.obstacle = obstacle;
        return hasObstacle();
    }

    public boolean hasObstacle(){
        return obstacle != null;
    }

    public int getPosition(){
        return hasObstacle() ? obstacle.getFinalPosition() : position;
    }

    public Obstacle getObstacle(){
        return obstacle;
    }

}
