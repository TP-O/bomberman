package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionD extends Explosion
{
    public ExplosionD(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionD.crop(14, 0, 193, 193));
        stand.add(Asset.explosionD.crop(209, 0, 193, 193));
        stand.add(Asset.explosionD.crop(411, 0, 193, 193));
        stand.add(Asset.explosionD.crop(610, 0, 193, 193));
        stand.add(Asset.explosionD.crop(806, 0, 193, 193));
        stand.add(Asset.explosionD.crop(11, 186, 193, 193));
        stand.add(Asset.explosionD.crop(201, 186, 193, 193));
        stand.add(Asset.explosionD.crop(395, 186, 193, 193));
        stand.add(Asset.explosionD.crop(596, 186, 193, 193));
        stand.add(Asset.explosionD.crop(792, 186, 193, 193));
        stand.add(Asset.explosionD.crop(17, 383, 193, 193));
        stand.add(Asset.explosionD.crop(208, 383, 193, 193));
        stand.add(Asset.explosionD.crop(397, 383, 193, 193));
        stand.add(Asset.explosionD.crop(592, 383, 193, 193));
        stand.add(Asset.explosionD.crop(793, 383, 193, 193));
    }
}
