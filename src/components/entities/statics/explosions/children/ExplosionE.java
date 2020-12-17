package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionE extends Explosion
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

        frames.add(Asset.explosionE.crop(0, 28, 137, 150));
        frames.add(Asset.explosionE.crop(117, 0, 157, 150));
        frames.add(Asset.explosionE.crop(273, 0, 157, 150));
        frames.add(Asset.explosionE.crop(447, 27, 157, 150));
        frames.add(Asset.explosionE.crop(43, 226, 157, 177));
        frames.add(Asset.explosionE.crop(237, 210, 157, 184));
        frames.add(Asset.explosionE.crop(434, 210, 144, 184));
    }
}
