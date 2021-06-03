package modules.camera;

import modules.Module;
import config.GameConfig;
import core.Handler;
import components.entities.dynamics.characters.Character;
import components.tiles.Tile;

public class Camera implements Module {

    private Handler handler;

    private float xOffset, yOffset = 0.0f;

    public float getXOffset() {
        return xOffset;
    }

    public float getYOffset() {
        return yOffset;
    }

    public void focusOn(Character character) {
        // Make the camera always follows the getEntity()
        xOffset = character.getX() - GameConfig.WIDTH / 2 + character.getWidth() / 2;
        yOffset = character.getY() - GameConfig.HEIGHT / 2 + character.getHeight() / 2;

        checkOffsets();
    }

    public void checkOffsets() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset + GameConfig.WIDTH > handler.getMap().getWidth() * Tile.WIDTH) {
            xOffset = handler.getMap().getWidth() * Tile.WIDTH - GameConfig.WIDTH;
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset + GameConfig.HEIGHT > handler.getMap().getHeight() * Tile.HEIGHT) {
            yOffset = handler.getMap().getHeight() * Tile.HEIGHT - GameConfig.HEIGHT;
        }
    }

    @Override
    public void register(Handler handler) {
        this.handler = handler;
    }
}
