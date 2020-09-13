package core.entity.characters;

import java.awt.Graphics;
import core.asset.Asset;
import core.game.Game;
import java.awt.image.BufferedImage;

public class Player extends Characters
{
    private BufferedImage BImage;

    public Player(Game inGame, float inX, float inY, int inWidth, int inHeight, int inHealth, float inSpeed)
    {
        super(inGame ,inX, inY, inWidth, inHeight, inHealth, inSpeed);
        BImage = Asset.player;
    }

    public void tick()
    {
        if (game.getKeyManager().up.pressed) y -= speed;
        if (game.getKeyManager().down.pressed) y += speed;
        if (game.getKeyManager().left.pressed) x -= speed;
        if (game.getKeyManager().right.pressed) x += speed;
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(BImage,
            (int) (x - game.getCamera().getXOffset()),
            (int) (y - game.getCamera().getYOffset()),
            width, height, null);
    }
}
