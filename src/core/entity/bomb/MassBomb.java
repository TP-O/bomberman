package core.entity.bomb;

import java.util.ArrayList;

import app.controller.GameController;
import core.asset.Asset;
import core.entity.explosion.*;

import java.awt.image.BufferedImage;

public class MassBomb extends Bomb
{
    public MassBomb(GameController game, float x, float y)
    {
        super(game, x, y);

        range = 3;
        damage = 10;
        timer = 1000;
    }

    @Override
    protected void loadSize()
    {
        width = 64;
        height = 64;
        x -= width/2;
        y-= height/2;
    }

    @Override
    protected void loadBombImage()
    {
        stand = new ArrayList<BufferedImage>();

        stand.add(Asset.bomb.crop(8, 11, 207, 196));
        stand.add(Asset.bomb.crop(218, 7, 207, 196));
        stand.add(Asset.bomb.crop(447, 7, 207, 196));
        stand.add(Asset.bomb.crop(647, 7, 207, 196));
        stand.add(Asset.bomb.crop(852, 7, 207, 196));
        stand.add(Asset.bomb.crop(1054, 7, 207, 196));
    }

    @Override
    protected void createExplosion()
    {
        explosion.createExplosion(new NuclearExplosion(game,
                calculateExplosionX(width*2),
                calculateExplosionY(height*2, false),
                width*3, height*3, timer, damage));

        // for (int i = 1; i <= range; i++) {
        //     explosion.createExplosion(new FireExplosion(x, y - height*i, width, height, timer, damage));
        //     explosion.createExplosion(new FireExplosion(x + width*i, y, width, height, timer, damage));
        //     explosion.createExplosion(new FireExplosion(x, y + height*i,width, height, timer, damage));
        //     explosion.createExplosion(new FireExplosion(x - width*i, y, width, height, timer, damage));
        // }
    }
}
