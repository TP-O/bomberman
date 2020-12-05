package core.entity.explosion.children;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.Explosion;

import java.awt.image.BufferedImage;

public class ExplosionL extends Explosion
{
    public ExplosionL(GameController game)
    {
        super(game);
    }

    @Override
    protected void loadExplosionImage()
    {
        images= new ArrayList<BufferedImage>();

        images.add(Asset.explosionL.crop(519, 69, 144, 125));
        images.add(Asset.explosionL.crop(668, 69, 144, 125));
        images.add(Asset.explosionL.crop(840, 69, 144, 125));
        images.add(Asset.explosionL.crop(522, 213, 144, 125));
        images.add(Asset.explosionL.crop(673, 213, 144, 125));
        images.add(Asset.explosionL.crop(834, 213, 144, 125));
        images.add(Asset.explosionL.crop(521, 358, 144, 125));
        images.add(Asset.explosionL.crop(671, 358, 144, 125));
        images.add(Asset.explosionL.crop(840, 358, 144, 125));
    }
}
