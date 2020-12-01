package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionJ extends Explosion
{
    public ExplosionJ(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionJ.crop(46, 172, 137, 126));
        stand.add(Asset.explosionJ.crop(195, 172, 137, 126));
        stand.add(Asset.explosionJ.crop(349, 172, 137, 126));
        stand.add(Asset.explosionJ.crop(505, 172, 137, 126));
        stand.add(Asset.explosionJ.crop(655, 172, 137, 126));
        stand.add(Asset.explosionJ.crop(810, 172, 137, 126));
        stand.add(Asset.explosionJ.crop(48, 312, 137, 126));
        stand.add(Asset.explosionJ.crop(203, 312, 137, 126));
        stand.add(Asset.explosionJ.crop(353, 312, 137, 126));
        stand.add(Asset.explosionJ.crop(492, 312, 137, 126));
        stand.add(Asset.explosionJ.crop(645, 312, 137, 126));
    }
}
