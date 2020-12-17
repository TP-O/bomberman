package components.entities.fixed.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.fixed.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionE extends Explosion
{
    public ExplosionE(Handler handler)
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

        frames.add(Asset.explosionE.crop(0, 28, 137, 150));
        frames.add(Asset.explosionE.crop(117, 0, 157, 150));
        frames.add(Asset.explosionE.crop(273, 0, 157, 150));
        frames.add(Asset.explosionE.crop(447, 27, 157, 150));
        frames.add(Asset.explosionE.crop(43, 226, 157, 177));
        frames.add(Asset.explosionE.crop(237, 210, 157, 184));
        frames.add(Asset.explosionE.crop(434, 210, 144, 184));
    }
}
