package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionC extends Explosion
{
    public ExplosionC(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionC.crop(74, 74, 319, 319));
        stand.add(Asset.explosionC.crop(445, 74, 319, 319));
        stand.add(Asset.explosionC.crop(815, 74, 319, 319));
        stand.add(Asset.explosionC.crop(103, 466, 319, 319));
        stand.add(Asset.explosionC.crop(496, 466, 319, 319));
        stand.add(Asset.explosionC.crop(869, 466, 319, 319));
    }
}
