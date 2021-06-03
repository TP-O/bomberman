package factories.obstacle;

import components.entities.statics.obstacles.Obstacle;
import components.entities.statics.obstacles.children.*;

public class BasicObstacleFactory implements ObstacleFactory {

    @Override
    public Obstacle createObstacle(String type, float x, float y) {
        Obstacle obstacle = null;

        switch (type) {
            case "Rock":
                obstacle = new Rock(x, y);
                break;

            default:
                obstacle = null;
        }

        return obstacle;
    }
}
