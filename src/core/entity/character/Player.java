package core.entity.character;

import java.awt.Graphics;
import core.asset.Asset;
import helper.Helper;
import app.controller.GameController;

public class Player extends Character
{
    private int space = 5;

    private int margin = 4;

    public Player(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(gameController , x, y, width, height, health, damage, speed, Asset.player);
    }

    public void tick()
    {
        if (gameController.getKeyService().up.pressed
            && !isCollied(Helper.getXOfTile(x), Helper.getYOfTile(y - margin))
            && !isCollied(Helper.getXOfTile(x + space), Helper.getYOfTile(y - margin))
            && !isCollied(Helper.getXOfTile(x + width), Helper.getYOfTile(y - margin))
            && !isCollied(Helper.getXOfTile(x + width - space), Helper.getYOfTile(y - margin))
        ) {
            y -= speed;
        }
        if (gameController.getKeyService().down.pressed
            && !isCollied(Helper.getXOfTile(x), Helper.getYOfTile(y + height + margin))
            && !isCollied(Helper.getXOfTile(x + space), Helper.getYOfTile(y + height + margin))
            && !isCollied(Helper.getXOfTile(x + width), Helper.getYOfTile(y + height + margin))
            && !isCollied(Helper.getXOfTile(x + width - space), Helper.getYOfTile(y + height + margin))
        ) {
            y += speed;
        }
        if (gameController.getKeyService().left.pressed
            && !isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y))
            && !isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y + space))
            && !isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y + height))
            && !isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y + height - space))
        ) {
            x -= speed;
        }
        if (gameController.getKeyService().right.pressed
            && !isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y))
            && !isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y + space))
            && !isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y + height))
            && !isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y + height - space))
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
