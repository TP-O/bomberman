package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionA extends Explosion
{
    public ExplosionA(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionA.crop(2, 0, 298, 302));
        images.add(Asset.explosionA.crop(306, 23, 298, 302));
        images.add(Asset.explosionA.crop(641, 9, 298, 302));
        images.add(Asset.explosionA.crop(965, 19, 298, 302));
        images.add(Asset.explosionA.crop(1311, 4, 298, 302));
        images.add(Asset.explosionA.crop(1662, 17, 298, 302));
        images.add(Asset.explosionA.crop(43, 385, 298, 302));
        images.add(Asset.explosionA.crop(394, 387, 298, 302));
        images.add(Asset.explosionA.crop(736, 394, 298, 302));
        images.add(Asset.explosionA.crop(1038, 398, 298, 302));
        images.add(Asset.explosionA.crop(1319, 395, 298, 302));
        images.add(Asset.explosionA.crop(1652, 383, 298, 302));
    }
}
