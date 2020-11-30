package core.entity.explosion;

import java.util.ArrayList;

import core.asset.Asset;

import java.awt.image.BufferedImage;

public class SmallExplosionB extends Explosion
{
    public SmallExplosionB(float x, float y, int width, int height, int timer, int damage)
    {
        super(x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.bomb.crop(15, 261, 216, 216));
        stand.add(Asset.bomb.crop(253, 265, 216, 216));
        stand.add(Asset.bomb.crop(500, 264, 216, 216));
        stand.add(Asset.bomb.crop(734, 261, 216, 216));
        stand.add(Asset.bomb.crop(973, 263, 216, 216));
        stand.add(Asset.bomb.crop(1207, 263, 216, 216));
    }
}
