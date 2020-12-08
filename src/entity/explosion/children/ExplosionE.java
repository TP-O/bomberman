package entity.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.main.Handler;
import entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionE extends Explosion
{
    public ExplosionE(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void loadInfo()
    {
        damage = 5;
        deleted = false;
    }

    @Override
    protected void loadImages()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionE.crop(0, 28, 137, 150));
        images.add(Asset.explosionE.crop(117, 0, 157, 150));
        images.add(Asset.explosionE.crop(273, 0, 157, 150));
        images.add(Asset.explosionE.crop(447, 27, 157, 150));
        images.add(Asset.explosionE.crop(43, 226, 157, 177));
        images.add(Asset.explosionE.crop(237, 210, 157, 184));
        images.add(Asset.explosionE.crop(434, 210, 144, 184));
    }
}
