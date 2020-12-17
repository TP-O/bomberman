package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionH extends Explosion
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

        frames.add(Asset.explosionH.crop(51, 52, 298, 302));
        frames.add(Asset.explosionH.crop(352, 52, 298, 302));
        frames.add(Asset.explosionH.crop(654, 52, 298, 302));
        frames.add(Asset.explosionH.crop(49, 351, 298, 302));
        frames.add(Asset.explosionH.crop(355, 351, 298, 302));
        frames.add(Asset.explosionH.crop(652, 351, 298, 302));
        frames.add(Asset.explosionH.crop(55, 648, 298, 302));
        frames.add(Asset.explosionH.crop(355, 648, 298, 302));
        frames.add(Asset.explosionH.crop(653, 648, 298, 302));
    }
}
