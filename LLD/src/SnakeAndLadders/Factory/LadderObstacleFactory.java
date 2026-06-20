package SnakeAndLadders.Factory;

import SnakeAndLadders.Entities.Obstacle.LadderObstacle;
import SnakeAndLadders.Entities.Obstacle.Obstacle;

public class LadderObstacleFactory implements ObstacleFactory{

    @Override
    public Obstacle createObstacle(int src, int dest) {
        return new LadderObstacle(src, dest);
    }
}
