package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionG extends Explosion
{
    public ExplosionG(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionG.crop(86, 127, 175, 165));
        stand.add(Asset.explosionG.crop(298, 127, 175, 165));
        stand.add(Asset.explosionG.crop(512, 127, 175, 165));
        stand.add(Asset.explosionG.crop(726, 127, 175, 165));
        stand.add(Asset.explosionG.crop(99, 357, 175, 165));
        stand.add(Asset.explosionG.crop(311, 357, 175, 165));
        stand.add(Asset.explosionG.crop(528, 357, 175, 165));
        stand.add(Asset.explosionG.crop(730, 357, 175, 165));
    }
}
