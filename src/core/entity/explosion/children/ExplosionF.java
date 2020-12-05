package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionF extends Explosion
{
    public ExplosionF(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionF.crop(44, 35, 251, 258));
        images.add(Asset.explosionF.crop(359, 35, 251, 258));
        images.add(Asset.explosionF.crop(695, 35, 251, 258));
        images.add(Asset.explosionF.crop(36, 370, 251, 258));
        images.add(Asset.explosionF.crop(376, 370, 251, 258));
        images.add(Asset.explosionF.crop(705, 370, 251, 258));
        images.add(Asset.explosionF.crop(34, 704, 251, 258));
        images.add(Asset.explosionF.crop(361, 704, 251, 258));
        images.add(Asset.explosionF.crop(691, 704, 251, 258));
    }
}
