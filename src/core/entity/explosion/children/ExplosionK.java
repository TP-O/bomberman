package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionK extends Explosion
{
    public ExplosionK(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionK.crop(65, 104, 189, 162));
        images.add(Asset.explosionK.crop(288, 104, 189, 162));
        images.add(Asset.explosionK.crop(516, 104, 189, 162));
        images.add(Asset.explosionK.crop(742, 104, 189, 162));
        images.add(Asset.explosionK.crop(68, 301, 189, 162));
        images.add(Asset.explosionK.crop(294, 301, 189, 162));
        images.add(Asset.explosionK.crop(516, 301, 189, 162));
        images.add(Asset.explosionK.crop(742, 301, 189, 162));
        images.add(Asset.explosionK.crop(64, 497, 189, 162));
        images.add(Asset.explosionK.crop(291, 497, 189, 162));
        images.add(Asset.explosionK.crop(514, 497, 189, 162));
        images.add(Asset.explosionK.crop(726, 497, 189, 162));
    }
}
