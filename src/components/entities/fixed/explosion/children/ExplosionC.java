package components.entities.fixed.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.fixed.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionC extends Explosion
{
    public ExplosionC(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void setEntityParameters()
    {
        damage = 5;
    }

    @Override
    protected void loadAllFrames()
    {
        frames = new ArrayList<BufferedImage>();

        frames.add(Asset.explosionC.crop(74, 74, 319, 319));
        frames.add(Asset.explosionC.crop(445, 74, 319, 319));
        frames.add(Asset.explosionC.crop(815, 74, 319, 319));
        frames.add(Asset.explosionC.crop(103, 466, 319, 319));
        frames.add(Asset.explosionC.crop(496, 466, 319, 319));
        frames.add(Asset.explosionC.crop(869, 466, 319, 319));
    }
}
