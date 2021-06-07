package app.models;

import org.json.simple.JSONObject;

import components.entities.statics.obstacles.Obstacle;
import factories.obstacle.BasicObstacleFactory;
import factories.obstacle.ObstacleFactory;

public class ObstacleModel extends Model<Obstacle> {

    private ObstacleFactory factory = new BasicObstacleFactory();

    @Override
    protected void set() {
        table = "res/data/obstacle.json";
    }

    @Override
    protected void parseObject(JSONObject obstacle) {
        listData.add(factory.createObstacle((String) obstacle.get("type"),
                Float.parseFloat(String.valueOf((double) obstacle.get("x"))),
                Float.parseFloat(String.valueOf((double) obstacle.get("y")))));
    }
}
