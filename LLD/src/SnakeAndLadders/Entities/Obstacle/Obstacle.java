package SnakeAndLadders.Entities.Obstacle;

import SnakeAndLadders.Enums.ObstacleType;

public abstract class Obstacle {

    public int src;
    public int dest;

    protected Obstacle(int src, int dest){
        this.src = src;
        this.dest = dest;
    }

    public abstract int getFinalPosition();

    public abstract ObstacleType getObstacletype();
}
