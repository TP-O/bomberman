package entity.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.main.Handler;
import entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionA extends Explosion
{
    public ExplosionA(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionA.crop(2, 0, 298, 302));
        images.add(Asset.explosionA.crop(306, 23, 298, 302));
        images.add(Asset.explosionA.crop(641, 9, 298, 302));
        images.add(Asset.explosionA.crop(965, 19, 298, 302));
        images.add(Asset.explosionA.crop(1311, 4, 298, 302));
        images.add(Asset.explosionA.crop(1662, 17, 298, 302));
        images.add(Asset.explosionA.crop(43, 385, 298, 302));
        images.add(Asset.explosionA.crop(394, 387, 298, 302));
        images.add(Asset.explosionA.crop(736, 394, 298, 302));
        images.add(Asset.explosionA.crop(1038, 398, 298, 302));
        images.add(Asset.explosionA.crop(1319, 395, 298, 302));
        images.add(Asset.explosionA.crop(1652, 383, 298, 302));
    }

    @Override
    protected void loadDefaultValues()
    {
        damage = 5;
        deleted = false;
    }
}
