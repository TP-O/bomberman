package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionJ extends Explosion
{
    public ExplosionJ(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionJ.crop(46, 172, 137, 126));
        images.add(Asset.explosionJ.crop(195, 172, 137, 126));
        images.add(Asset.explosionJ.crop(349, 172, 137, 126));
        images.add(Asset.explosionJ.crop(505, 172, 137, 126));
        images.add(Asset.explosionJ.crop(655, 172, 137, 126));
        images.add(Asset.explosionJ.crop(810, 172, 137, 126));
        images.add(Asset.explosionJ.crop(48, 312, 137, 126));
        images.add(Asset.explosionJ.crop(203, 312, 137, 126));
        images.add(Asset.explosionJ.crop(353, 312, 137, 126));
        images.add(Asset.explosionJ.crop(492, 312, 137, 126));
        images.add(Asset.explosionJ.crop(645, 312, 137, 126));
    }
}
