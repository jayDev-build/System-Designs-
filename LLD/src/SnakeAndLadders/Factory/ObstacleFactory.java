package SnakeAndLadders.Factory;

import SnakeAndLadders.Entities.Obstacle.Obstacle;

public interface ObstacleFactory {
    public Obstacle createObstacle(int src, int dest);
}
