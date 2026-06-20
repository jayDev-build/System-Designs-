package SnakeAndLadders.Entities.Obstacle;

import SnakeAndLadders.Enums.ObstacleType;

public class SnakeObstacle extends Obstacle{

    public SnakeObstacle(int src, int dest){
        super(src, dest);
    }

    @Override
    public int getFinalPosition() {
        return dest;
    }

    @Override
    public ObstacleType getObstacletype() {
        return ObstacleType.SNAKE;
    }
}
