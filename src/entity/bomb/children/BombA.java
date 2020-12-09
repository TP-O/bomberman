package entity.bomb.children;

import java.util.ArrayList;

import app.event.event.ExplosionEvent;
import asset.Asset;
import core.main.Handler;
import entity.bomb.Bomb;
import entity.explosion.children.ExplosionA;
import helper.Helper;

import java.awt.image.BufferedImage;

public class BombA extends Bomb
{
    public BombA(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void loadInfo()
    {
        width = 32;
        height = 32;
        range = 2;
        timer = 1000;
        deleted = false;
        
        explosion = new ExplosionA(handler);
    }

    @Override
    protected void loadImages()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.bomb.crop(8, 11, 207, 196));
        images.add(Asset.bomb.crop(218, 7, 207, 196));
        images.add(Asset.bomb.crop(447, 7, 207, 196));
        images.add(Asset.bomb.crop(647, 7, 207, 196));
        images.add(Asset.bomb.crop(852, 7, 207, 196));
        images.add(Asset.bomb.crop(1054, 7, 207, 196));
    }

    @Override
    public void tick()
    {
        long now = System.currentTimeMillis();

        // The bomb will be deleted if the time is up
        if (now - createdTime >= timer) {
            Helper.event(new ExplosionEvent(explosion, this, 2 * width, 2 * height, range));
            deleted = true;
        }
        else {
            super.tick();
        }
    }
}
