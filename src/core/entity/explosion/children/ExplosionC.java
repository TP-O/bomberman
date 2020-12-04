package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionC extends Explosion
{
    public ExplosionC(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionC.crop(74, 74, 319, 319));
        images.add(Asset.explosionC.crop(445, 74, 319, 319));
        images.add(Asset.explosionC.crop(815, 74, 319, 319));
        images.add(Asset.explosionC.crop(103, 466, 319, 319));
        images.add(Asset.explosionC.crop(496, 466, 319, 319));
        images.add(Asset.explosionC.crop(869, 466, 319, 319));
    }
}
