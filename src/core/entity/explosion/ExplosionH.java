package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionH extends Explosion
{
    public ExplosionH(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionH.crop(51, 52, 298, 302));
        stand.add(Asset.explosionH.crop(352, 52, 298, 302));
        stand.add(Asset.explosionH.crop(654, 52, 298, 302));
        stand.add(Asset.explosionH.crop(49, 351, 298, 302));
        stand.add(Asset.explosionH.crop(355, 351, 298, 302));
        stand.add(Asset.explosionH.crop(652, 351, 298, 302));
        stand.add(Asset.explosionH.crop(55, 648, 298, 302));
        stand.add(Asset.explosionH.crop(355, 648, 298, 302));
        stand.add(Asset.explosionH.crop(653, 648, 298, 302));
    }
}
