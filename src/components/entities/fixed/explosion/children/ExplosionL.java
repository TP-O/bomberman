package components.entities.fixed.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.fixed.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionL extends Explosion
{
    public ExplosionL(Handler handler)
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

        frames.add(Asset.explosionL.crop(519, 69, 144, 125));
        frames.add(Asset.explosionL.crop(668, 69, 144, 125));
        frames.add(Asset.explosionL.crop(840, 69, 144, 125));
        frames.add(Asset.explosionL.crop(522, 213, 144, 125));
        frames.add(Asset.explosionL.crop(673, 213, 144, 125));
        frames.add(Asset.explosionL.crop(834, 213, 144, 125));
        frames.add(Asset.explosionL.crop(521, 358, 144, 125));
        frames.add(Asset.explosionL.crop(671, 358, 144, 125));
        frames.add(Asset.explosionL.crop(840, 358, 144, 125));
    }
}
