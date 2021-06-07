package factories.obstacle;

import components.entities.statics.obstacles.Obstacle;

public interface ObstacleFactory {
    public Obstacle createObstacle(String type, float x, float y);
}
