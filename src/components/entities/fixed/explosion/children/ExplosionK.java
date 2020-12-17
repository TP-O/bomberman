package components.entities.fixed.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.fixed.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionK extends Explosion
{
    public ExplosionK(Handler handler)
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

        frames.add(Asset.explosionK.crop(65, 104, 189, 162));
        frames.add(Asset.explosionK.crop(288, 104, 189, 162));
        frames.add(Asset.explosionK.crop(516, 104, 189, 162));
        frames.add(Asset.explosionK.crop(742, 104, 189, 162));
        frames.add(Asset.explosionK.crop(68, 301, 189, 162));
        frames.add(Asset.explosionK.crop(294, 301, 189, 162));
        frames.add(Asset.explosionK.crop(516, 301, 189, 162));
        frames.add(Asset.explosionK.crop(742, 301, 189, 162));
        frames.add(Asset.explosionK.crop(64, 497, 189, 162));
        frames.add(Asset.explosionK.crop(291, 497, 189, 162));
        frames.add(Asset.explosionK.crop(514, 497, 189, 162));
        frames.add(Asset.explosionK.crop(726, 497, 189, 162));
    }
}
