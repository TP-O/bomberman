package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionB extends Explosion
{
    public ExplosionB(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.explosionB.crop(0, 44, 249, 237));
        images.add(Asset.explosionB.crop(182, 44, 249, 237));
        images.add(Asset.explosionB.crop(430, 44, 249, 237));
        images.add(Asset.explosionB.crop(720, 44, 249, 237));
        images.add(Asset.explosionB.crop(996, 44, 249, 237));
        images.add(Asset.explosionB.crop(40, 400, 249, 237));
        images.add(Asset.explosionB.crop(299, 400, 249, 237));
        images.add(Asset.explosionB.crop(555, 400, 249, 237));
        images.add(Asset.explosionB.crop(795, 400, 249, 237));
        images.add(Asset.explosionB.crop(1023, 400, 249, 237));
    }
}
