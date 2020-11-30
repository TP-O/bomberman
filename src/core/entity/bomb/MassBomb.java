package core.entity.bomb;

import java.util.ArrayList;

import core.asset.Asset;
import core.entity.explosion.FireExplosion;

import java.awt.image.BufferedImage;

public class MassBomb extends Bomb
{
    public MassBomb(float x, float y)
    {
        super(x, y, 42, 42);

        range = 3;
        damage = 10;
        timer = 1000;
    }

    @Override
    protected void loadBombImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.bomb.crop(28, 11, 187, 196));
        stand.add(Asset.bomb.crop(236, 7, 187, 196));
        stand.add(Asset.bomb.crop(470, 7, 187, 196));
        stand.add(Asset.bomb.crop(666, 7, 187, 196));
        stand.add(Asset.bomb.crop(868, 7, 187, 196));
        stand.add(Asset.bomb.crop(1074, 8, 187, 196));
    }

    @Override
    protected void createExplosion()
    {
        explosion.createExplosion(new FireExplosion(x, y, width, height, timer, damage));

        for (int i = 1; i <= range; i++) {
            explosion.createExplosion(new FireExplosion(x, y - height*i, width, height, timer, damage));
            explosion.createExplosion(new FireExplosion(x + width*i, y, width, height, timer, damage));
            explosion.createExplosion(new FireExplosion(x, y + height*i,width, height, timer, damage));
            explosion.createExplosion(new FireExplosion(x - width*i, y, width, height, timer, damage));
        }
    }
}
