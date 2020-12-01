package core.entity.explosion;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;

import java.awt.image.BufferedImage;

public class ExplosionL extends Explosion
{
    public ExplosionL(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height, timer, damage);
    }

    @Override
    protected void loadExplosionImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.explosionL.crop(519, 69, 144, 125));
        stand.add(Asset.explosionL.crop(668, 69, 144, 125));
        stand.add(Asset.explosionL.crop(840, 69, 144, 125));
        stand.add(Asset.explosionL.crop(522, 213, 144, 125));
        stand.add(Asset.explosionL.crop(673, 213, 144, 125));
        stand.add(Asset.explosionL.crop(834, 213, 144, 125));
        stand.add(Asset.explosionL.crop(521, 358, 144, 125));
        stand.add(Asset.explosionL.crop(671, 358, 144, 125));
        stand.add(Asset.explosionL.crop(840, 358, 144, 125));
    }
}
