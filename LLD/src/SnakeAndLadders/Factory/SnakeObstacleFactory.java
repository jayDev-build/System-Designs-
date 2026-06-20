package SnakeAndLadders.Factory;

import SnakeAndLadders.Entities.Obstacle.Obstacle;
import SnakeAndLadders.Entities.Obstacle.SnakeObstacle;

public class SnakeObstacleFactory implements ObstacleFactory{

    @Override
    public Obstacle createObstacle(int src, int dest) {
        return new SnakeObstacle(src, dest);
    }
}
