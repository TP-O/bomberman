package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionB extends Explosion
{
    public ExplosionB(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionB.crop(0, 44, 249, 237));
        stand.add(Asset.explosionB.crop(182, 44, 249, 237));
        stand.add(Asset.explosionB.crop(430, 44, 249, 237));
        stand.add(Asset.explosionB.crop(720, 44, 249, 237));
        stand.add(Asset.explosionB.crop(996, 44, 249, 237));
        stand.add(Asset.explosionB.crop(40, 400, 249, 237));
        stand.add(Asset.explosionB.crop(299, 400, 249, 237));
        stand.add(Asset.explosionB.crop(555, 400, 249, 237));
        stand.add(Asset.explosionB.crop(795, 400, 249, 237));
        stand.add(Asset.explosionB.crop(1023, 400, 249, 237));
    }
}
