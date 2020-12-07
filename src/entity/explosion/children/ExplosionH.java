package entity.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.main.Handler;
import entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionH extends Explosion
{
    public ExplosionH(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionH.crop(51, 52, 298, 302));
        images.add(Asset.explosionH.crop(352, 52, 298, 302));
        images.add(Asset.explosionH.crop(654, 52, 298, 302));
        images.add(Asset.explosionH.crop(49, 351, 298, 302));
        images.add(Asset.explosionH.crop(355, 351, 298, 302));
        images.add(Asset.explosionH.crop(652, 351, 298, 302));
        images.add(Asset.explosionH.crop(55, 648, 298, 302));
        images.add(Asset.explosionH.crop(355, 648, 298, 302));
        images.add(Asset.explosionH.crop(653, 648, 298, 302));
    }

    @Override
    protected void loadDefaultValues()
    {
        damage = 5;
        deleted = false;
    }
}
