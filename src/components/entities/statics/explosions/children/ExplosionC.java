package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionC extends Explosion
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

        frames.add(Asset.explosionC.crop(74, 74, 319, 319));
        frames.add(Asset.explosionC.crop(445, 74, 319, 319));
        frames.add(Asset.explosionC.crop(815, 74, 319, 319));
        frames.add(Asset.explosionC.crop(103, 466, 319, 319));
        frames.add(Asset.explosionC.crop(496, 466, 319, 319));
        frames.add(Asset.explosionC.crop(869, 466, 319, 319));
    }
}
