package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionG extends Explosion
{
    public ExplosionG(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionG.crop(86, 127, 175, 165));
        images.add(Asset.explosionG.crop(298, 127, 175, 165));
        images.add(Asset.explosionG.crop(512, 127, 175, 165));
        images.add(Asset.explosionG.crop(726, 127, 175, 165));
        images.add(Asset.explosionG.crop(99, 357, 175, 165));
        images.add(Asset.explosionG.crop(311, 357, 175, 165));
        images.add(Asset.explosionG.crop(528, 357, 175, 165));
        images.add(Asset.explosionG.crop(730, 357, 175, 165));
    }
}
