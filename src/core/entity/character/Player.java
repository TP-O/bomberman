package core.entity.character;

import java.awt.Graphics;
import core.asset.Asset;
import app.controller.GameController;

public class Player extends Character
{
    private int space = 5;

    public Player(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(gameController , x, y, width, height, health, damage, speed, Asset.player);
    }

    public void tick()
    {
        if (gameController.getKeyService().up.pressed
            && !isCollied((int) x, (int) (y - space))
            && !isCollied((int) (x + 1), (int) (y - space))
        ) {
            y -= speed;
        }
        if (gameController.getKeyService().down.pressed
            && !isCollied((int) x, (int) (y + height + space))
            && !isCollied((int) (x + 1), (int) (y + height + space))
        ) {
            y += speed;
        }
        if (gameController.getKeyService().left.pressed
            && !isCollied((int) (x -space), (int) y)
            && !isCollied((int) (x -space), (int) (y + 1))
        ) {
            x -= speed;
        }
        if (gameController.getKeyService().right.pressed
            && !isCollied((int) (x + width + space), (int) y)
            && !isCollied((int) (x + width + space), (int) (y + 1))
        ) {
            x += speed;
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(BImage,
            (int) (x - gameController.getCameraService().getXOffset()),
            (int) (y - gameController.getCameraService().getYOffset()),
            width, height, null);
    }
}
