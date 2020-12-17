package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionL extends Explosion
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
