package core.service.camera;

import app.controller.GameController;
import core.entity.Entity;
import core.service.Service;
import core.tile.Tile;

public class CameraService implements Service
{
    private GameController game;

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
        xOffset = entity.getX() - game.getWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - game.getHeight() / 2 + entity.getHeight() / 2;

        checkOffsets();
    }

    public void checkOffsets()
    {
        if (xOffset < 0) {
            xOffset = 0;
        }
        else if (xOffset + game.getWidth() > game.getMap().getWidth()*Tile.WIDTH) {
            xOffset = game.getMap().getWidth()*Tile.WIDTH - game.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        }
        else if (yOffset + game.getHeight() > game.getMap().getHeight()*Tile.HEIGHT) {
            yOffset = game.getMap().getHeight()*Tile.HEIGHT - game.getHeight();
        }
    }

    public void register(GameController game)
    {
        this.game = game;
    }
}
