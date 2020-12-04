package core.entity.bomb.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.bomb.Bomb;
import core.entity.explosion.children.*;

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
    protected void loadExplosion()
    {
        explosiveStrategy = new ExplosionB(game);
    }

    @Override
    protected void createExplosion()
    {
        int explosionWidth = 2*width;
        int explosionHeight = 2*height;

        explosiveStrategy.createExplosion(
                calculateXOfExplosion(explosionWidth),
                calculateYOfExplosion(explosionHeight, false),
                explosionWidth,
                explosionHeight
        );
    }
}
