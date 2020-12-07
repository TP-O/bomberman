package entity.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.main.Handler;
import entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionG extends Explosion
{
    public ExplosionG(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionG.crop(86, 127, 175, 165));
        images.add(Asset.explosionG.crop(298, 127, 175, 165));
        images.add(Asset.explosionG.crop(512, 127, 175, 165));
        images.add(Asset.explosionG.crop(726, 127, 175, 165));
        images.add(Asset.explosionG.crop(99, 357, 175, 165));
        images.add(Asset.explosionG.crop(311, 357, 175, 165));
        images.add(Asset.explosionG.crop(528, 357, 175, 165));
        images.add(Asset.explosionG.crop(730, 357, 175, 165));
    }

    @Override
    protected void loadDefaultValues()
    {
        damage = 5;
        deleted = false;
    }
}
