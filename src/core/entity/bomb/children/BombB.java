package core.entity.bomb.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.bomb.Bomb;
import core.entity.explosion.children.ExplosionD;

import java.awt.image.BufferedImage;

public class BombB extends Bomb
{
    private int range = 3;

    public BombB(GameController game)
    {
        super(game);
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

        explosiveStrategy = new ExplosionD(game);
        
        // Create a plus-shaped explosion at the bomb spot
        explosiveStrategy.createExplosion(calculateXOfExplosion(explosionWidth),
                calculateYOfExplosion(explosionHeight, true),
                explosionWidth,
                explosionHeight);

        for (int i = 1; i <= range; i++) {
            explosiveStrategy.createExplosion(calculateXOfExplosion(explosionWidth),
                    calculateYOfExplosion(explosionHeight, true) - explosionHeight*i,
                    explosionWidth,
                    explosionHeight);
            explosiveStrategy.createExplosion(calculateXOfExplosion(explosionWidth)+ explosionWidth*i,
                    calculateYOfExplosion(explosionHeight, true),
                    explosionWidth,
                    explosionHeight);
            explosiveStrategy.createExplosion(calculateXOfExplosion(explosionWidth),
                    calculateYOfExplosion(explosionHeight, true) + explosionHeight*i,
                    explosionWidth,
                    explosionHeight);
            explosiveStrategy.createExplosion(calculateXOfExplosion(explosionWidth) - explosionWidth*i,
                    calculateYOfExplosion(explosionHeight, true),
                    explosionWidth,
                    explosionHeight);
        }
    }
}
