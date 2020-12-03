package core.entity.bomb;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.*;

import java.awt.image.BufferedImage;

public class BombA extends Bomb
{
    public BombA(GameController game, float x, float y)
    {
        super(game, x, y);
    }

    @Override
    protected void loadBombImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.bomb.crop(8, 11, 207, 196));
        images.add(Asset.bomb.crop(218, 7, 207, 196));
        images.add(Asset.bomb.crop(447, 7, 207, 196));
        images.add(Asset.bomb.crop(647, 7, 207, 196));
        images.add(Asset.bomb.crop(852, 7, 207, 196));
        images.add(Asset.bomb.crop(1054, 7, 207, 196));
    }

    @Override
    protected void createExplosion()
    {
        int explosionWidth = 3*width;
        int explosionHeight = 3*height;

        explosion.createExplosion(new ExplosionD(game,
                calculateXOfExplosion(explosionWidth),
                calculateYOfExplosion(explosionHeight, false),
                explosionWidth,
                explosionHeight));
    }
}
