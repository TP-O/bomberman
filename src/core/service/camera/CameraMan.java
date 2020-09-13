package core.service.camera;

import core.entity.Entity;
import core.game.Game;

public class CameraMan
{
    private float xOffset, yOffset;

    private Game game;

    public CameraMan(Game game, float xOffset, float yOffset)
    {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }    

    public void recordEntity(Entity e)
    {
        // Make the camera always follows the entity
        xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
    }

    public float getXOffset()
    {
        return xOffset;
    }

    public float getYOffset()
    {
        return yOffset;
    }
}
