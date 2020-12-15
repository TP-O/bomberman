package components.entities.fixed.explosion.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.fixed.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionD extends Explosion
{
    public ExplosionD(Handler handler)
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

        frames.add(Asset.explosionD.crop(14, 0, 193, 193));
        frames.add(Asset.explosionD.crop(209, 0, 193, 193));
        frames.add(Asset.explosionD.crop(411, 0, 193, 193));
        frames.add(Asset.explosionD.crop(610, 0, 193, 193));
        frames.add(Asset.explosionD.crop(806, 0, 193, 193));
        frames.add(Asset.explosionD.crop(11, 186, 193, 193));
        frames.add(Asset.explosionD.crop(201, 186, 193, 193));
        frames.add(Asset.explosionD.crop(395, 186, 193, 193));
        frames.add(Asset.explosionD.crop(596, 186, 193, 193));
        frames.add(Asset.explosionD.crop(792, 186, 193, 193));
        frames.add(Asset.explosionD.crop(17, 383, 193, 193));
        frames.add(Asset.explosionD.crop(208, 383, 193, 193));
        frames.add(Asset.explosionD.crop(397, 383, 193, 193));
        frames.add(Asset.explosionD.crop(592, 383, 193, 193));
        frames.add(Asset.explosionD.crop(793, 383, 193, 193));
    }
}
