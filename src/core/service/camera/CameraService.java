package core.service.camera;

import app.controller.GameController;
import core.entity.Entity;
import core.service.Service;
import core.tile.Tile;

public class CameraService implements Service
{
    private GameController gameController;

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
        xOffset = entity.getX() - gameController.getWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - gameController.getHeight() / 2 + entity.getHeight() / 2;

        checkOffsets();
    }

    public void checkOffsets()
    {
        if (xOffset < 0) {
            xOffset = 0;
        }
        else if (xOffset + gameController.getWidth() > gameController.getMapController().getWidth()*Tile.WIDTH) {
            xOffset = gameController.getMapController().getWidth()*Tile.WIDTH - gameController.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        }
        else if (yOffset + gameController.getHeight() > gameController.getMapController().getHeight()*Tile.HEIGHT) {
            yOffset = gameController.getMapController().getHeight()*Tile.HEIGHT - gameController.getHeight();
        }
    }

    public void register(GameController gameController)
    {
        this.gameController = gameController;
    }
}
