package core.entity.character;

import java.awt.Graphics;
import core.asset.Asset;
import core.game.Game;

public class Player extends Character
{
    public Player(Game game, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(game , x, y, width, height, health, damage, speed, Asset.player);
    }

    public void tick()
    {
        if (game.getKeyService().up.pressed) {
            y -= speed;
        }
        if (game.getKeyService().down.pressed) {
            y += speed;
        }
        if (game.getKeyService().left.pressed) {
            x -= speed;
        }
        if (game.getKeyService().right.pressed) {
            x += speed;
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(BImage,
            (int) (x - game.getCameraService().getXOffset()),
            (int) (y - game.getCameraService().getYOffset()),
            width, height, null);
    }
}
