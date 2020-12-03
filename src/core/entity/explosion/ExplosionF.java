package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionF extends Explosion
{
    public ExplosionF(GameController game, float x, float y, int width, int height)
    {
        super(game, x, y, width, height);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionF.crop(44, 35, 251, 258));
        stand.add(Asset.explosionF.crop(359, 35, 251, 258));
        stand.add(Asset.explosionF.crop(695, 35, 251, 258));
        stand.add(Asset.explosionF.crop(36, 370, 251, 258));
        stand.add(Asset.explosionF.crop(376, 370, 251, 258));
        stand.add(Asset.explosionF.crop(705, 370, 251, 258));
        stand.add(Asset.explosionF.crop(34, 704, 251, 258));
        stand.add(Asset.explosionF.crop(361, 704, 251, 258));
        stand.add(Asset.explosionF.crop(691, 704, 251, 258));
    }
}
