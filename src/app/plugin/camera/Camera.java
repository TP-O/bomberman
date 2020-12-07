package app.plugin.camera;

import entity.Entity;
import app.plugin.Plugin;
import config.GameConfig;
import core.main.Handler;
import tile.Tile;

public class Camera implements Plugin
{
    private Handler handler;

    private float xOffset, yOffset = 0.0f;

    public float getXOffset()
    {
        return xOffset;
    }

    public float getYOffset()
    {
        return yOffset;
    }

    public void focusOn(Entity entity)
    {
        // Make the camera always follows the entity
        xOffset = entity.getX() - GameConfig.WIDTH / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - GameConfig.HEIGHT / 2 + entity.getHeight() / 2;

        checkOffsets();
    }

    public void checkOffsets()
    {
        if (xOffset < 0) {
            xOffset = 0;
        }
        else if (xOffset + GameConfig.WIDTH > handler.getMap().getWidth()*Tile.WIDTH) {
            xOffset = handler.getMap().getWidth()*Tile.WIDTH - GameConfig.WIDTH;
        }

        if (yOffset < 0) {
            yOffset = 0;
        }
        else if (yOffset + GameConfig.HEIGHT > handler.getMap().getHeight()*Tile.HEIGHT) {
            yOffset = handler.getMap().getHeight()*Tile.HEIGHT - GameConfig.HEIGHT;
        }
    }

    @Override
    public void plug(Handler handler)
    {
        this.handler = handler;
    }
}
