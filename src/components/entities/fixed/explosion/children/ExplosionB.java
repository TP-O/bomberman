package components.entities.fixed.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.fixed.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionB extends Explosion
{
    public ExplosionB(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void setEntityParameters()
    {
        damage = 5;
        deleted = false;
    }

    @Override
    protected void loadAllFrames()
    {
        frames = new ArrayList<BufferedImage>();

        frames.add(Asset.explosionB.crop(0, 44, 249, 237));
        frames.add(Asset.explosionB.crop(182, 44, 249, 237));
        frames.add(Asset.explosionB.crop(430, 44, 249, 237));
        frames.add(Asset.explosionB.crop(720, 44, 249, 237));
        frames.add(Asset.explosionB.crop(996, 44, 249, 237));
        frames.add(Asset.explosionB.crop(40, 400, 249, 237));
        frames.add(Asset.explosionB.crop(299, 400, 249, 237));
        frames.add(Asset.explosionB.crop(555, 400, 249, 237));
        frames.add(Asset.explosionB.crop(795, 400, 249, 237));
        frames.add(Asset.explosionB.crop(1023, 400, 249, 237));
    }
}
