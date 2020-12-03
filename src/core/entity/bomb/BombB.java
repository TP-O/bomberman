package core.entity.bomb;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.*;

import java.awt.image.BufferedImage;

public class BombB extends Bomb
{
    private int range = 3;

    public BombB(GameController game, float x, float y)
    {
        super(game, x, y);
    }

    public int getRange() {
        return this.range;
    }

    public void setRange(int range) {
        this.range = range;
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
        int explosionWidth = 2*width;
        int explosionHeight = 2*height;

        explosion.createExplosion(new ExplosionK(game,
                calculateXOfExplosion(explosionWidth),
                calculateYOfExplosion(explosionHeight, true),
                explosionWidth,
                explosionHeight));

        for (int i = 1; i <= range; i++) {
            explosion.createExplosion(new ExplosionK(game,
                    calculateXOfExplosion(explosionWidth),
                    calculateYOfExplosion(explosionHeight, true) - explosionHeight*i,
                    explosionWidth,
                    explosionHeight));
            explosion.createExplosion(new ExplosionK(game,
                    calculateXOfExplosion(explosionWidth)+ explosionWidth*i,
                    calculateYOfExplosion(explosionHeight, true),
                    explosionWidth,
                    explosionHeight));
            explosion.createExplosion(new ExplosionK(game,
                    calculateXOfExplosion(explosionWidth),
                    calculateYOfExplosion(explosionHeight, true) + explosionHeight*i,
                    explosionWidth,
                    explosionHeight));
            explosion.createExplosion(new ExplosionK(game,
                    calculateXOfExplosion(explosionWidth) - explosionWidth*i,
                    calculateYOfExplosion(explosionHeight, true),
                    explosionWidth,
                    explosionHeight));
        } 
    }
}
