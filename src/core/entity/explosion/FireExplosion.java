package core.entity.explosion;

import java.util.ArrayList;

import core.asset.Asset;

import java.awt.image.BufferedImage;

public class FireExplosion extends Explosion
{
    public FireExplosion(float x, float y, int width, int height, int timer, int damage)
    {
        super(x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosion.crop(2, 0, 298, 302));
        stand.add(Asset.explosion.crop(306, 23, 298, 302));
        stand.add(Asset.explosion.crop(641, 9, 298, 302));
        stand.add(Asset.explosion.crop(965, 19, 298, 302));
        stand.add(Asset.explosion.crop(1311, 4, 298, 302));
        stand.add(Asset.explosion.crop(1662, 17, 298, 302));
        stand.add(Asset.explosion.crop(43, 385, 298, 302));
        stand.add(Asset.explosion.crop(394, 387, 298, 302));
        stand.add(Asset.explosion.crop(736, 394, 298, 302));
        stand.add(Asset.explosion.crop(1038, 398, 298, 302));
        stand.add(Asset.explosion.crop(1319, 395, 298, 302));
        stand.add(Asset.explosion.crop(1652, 383, 298, 302));
    }
}
