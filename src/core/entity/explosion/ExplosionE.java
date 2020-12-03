package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionE extends Explosion
{
    public ExplosionE(GameController game, float x, float y, int width, int height)
    {
        super(game, x, y, width, height);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionE.crop(0, 28, 137, 150));
        stand.add(Asset.explosionE.crop(117, 0, 157, 150));
        stand.add(Asset.explosionE.crop(273, 0, 157, 150));
        stand.add(Asset.explosionE.crop(447, 27, 157, 150));
        stand.add(Asset.explosionE.crop(43, 226, 157, 177));
        stand.add(Asset.explosionE.crop(237, 210, 157, 184));
        stand.add(Asset.explosionE.crop(434, 210, 144, 184));
    }
}
