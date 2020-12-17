package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionJ extends Explosion
{
    @Override
    protected void setEntityParameters()
    {
        damage = 5;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        frames.add(Asset.explosionJ.crop(46, 172, 137, 126));
        frames.add(Asset.explosionJ.crop(195, 172, 137, 126));
        frames.add(Asset.explosionJ.crop(349, 172, 137, 126));
        frames.add(Asset.explosionJ.crop(505, 172, 137, 126));
        frames.add(Asset.explosionJ.crop(655, 172, 137, 126));
        frames.add(Asset.explosionJ.crop(810, 172, 137, 126));
        frames.add(Asset.explosionJ.crop(48, 312, 137, 126));
        frames.add(Asset.explosionJ.crop(203, 312, 137, 126));
        frames.add(Asset.explosionJ.crop(353, 312, 137, 126));
        frames.add(Asset.explosionJ.crop(492, 312, 137, 126));
        frames.add(Asset.explosionJ.crop(645, 312, 137, 126));
    }
}
