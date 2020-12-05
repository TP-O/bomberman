package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionD extends Explosion
{
    public ExplosionD(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionD.crop(14, 0, 193, 193));
        images.add(Asset.explosionD.crop(209, 0, 193, 193));
        images.add(Asset.explosionD.crop(411, 0, 193, 193));
        images.add(Asset.explosionD.crop(610, 0, 193, 193));
        images.add(Asset.explosionD.crop(806, 0, 193, 193));
        images.add(Asset.explosionD.crop(11, 186, 193, 193));
        images.add(Asset.explosionD.crop(201, 186, 193, 193));
        images.add(Asset.explosionD.crop(395, 186, 193, 193));
        images.add(Asset.explosionD.crop(596, 186, 193, 193));
        images.add(Asset.explosionD.crop(792, 186, 193, 193));
        images.add(Asset.explosionD.crop(17, 383, 193, 193));
        images.add(Asset.explosionD.crop(208, 383, 193, 193));
        images.add(Asset.explosionD.crop(397, 383, 193, 193));
        images.add(Asset.explosionD.crop(592, 383, 193, 193));
        images.add(Asset.explosionD.crop(793, 383, 193, 193));
    }
}
