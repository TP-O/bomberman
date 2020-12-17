package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionK extends Explosion
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
