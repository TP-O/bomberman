package entity.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.main.Handler;
import entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionL extends Explosion
{
    public ExplosionL(Handler handler)
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
        images= new ArrayList<BufferedImage>();

        images.add(Asset.explosionL.crop(519, 69, 144, 125));
        images.add(Asset.explosionL.crop(668, 69, 144, 125));
        images.add(Asset.explosionL.crop(840, 69, 144, 125));
        images.add(Asset.explosionL.crop(522, 213, 144, 125));
        images.add(Asset.explosionL.crop(673, 213, 144, 125));
        images.add(Asset.explosionL.crop(834, 213, 144, 125));
        images.add(Asset.explosionL.crop(521, 358, 144, 125));
        images.add(Asset.explosionL.crop(671, 358, 144, 125));
        images.add(Asset.explosionL.crop(840, 358, 144, 125));
    }
}
