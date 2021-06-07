package components.entities.statics.obstacles;

import components.entities.statics.StaticEntity;
import config.TileConfig;

public abstract class Obstacle extends StaticEntity {

    public Obstacle(float x, float y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected void setEntityParameters() {
        margin = 0;
        padding = 0;
        width = TileConfig.WIDTH;
        height = TileConfig.HEIGHT;
    }
}
