package entity.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.main.Handler;
import entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionC extends Explosion
{
    public ExplosionC(Handler handler)
    {
        super(handler);
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

    @Override
    protected void loadDefaultValues()
    {
        damage = 5;
        deleted = false;
    }
}
