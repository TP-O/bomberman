package core.service.camera;

import core.game.Game;
import core.entity.Entity;
import core.service.Service;

public class CameraService implements Service
{
    private Game game;

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
    }

    public void register(Game game)
    {
        this.game = game;
    }
}
