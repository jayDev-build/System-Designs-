package SnakeAndLadders.Entities.Obstacle;

import SnakeAndLadders.Enums.ObstacleType;

public class LadderObstacle extends Obstacle{

    public LadderObstacle(int src, int dest) {
        super(src, dest);
    }

    @Override
    public int getFinalPosition() {
        return dest;
    }

    @Override
    public ObstacleType getObstacletype() {
        return ObstacleType.LADDER;
    }
}
