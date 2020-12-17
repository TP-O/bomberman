package components.entities.fixed.bomb.children;

import java.util.ArrayList;

import app.events.PlusExplosionEvent;
import asset.Asset;
import core.Handler;
import components.entities.fixed.explosion.children.ExplosionA;
import components.entities.fixed.bomb.Bomb;
import helper.Helper;

import java.awt.image.BufferedImage;

public class BombB extends Bomb
{
    public BombB(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void setEntityParameters()
    {
        width = 32;
        height = 32;
        range = 2;
        timer = 1000;

        explosion = new ExplosionA(handler);
    }

    @Override
    protected void loadAllFrames()
    {
        frames = new ArrayList<BufferedImage>();

        frames.add(Asset.bomb.crop(8, 11, 207, 196));
        frames.add(Asset.bomb.crop(218, 7, 207, 196));
        frames.add(Asset.bomb.crop(447, 7, 207, 196));
        frames.add(Asset.bomb.crop(647, 7, 207, 196));
        frames.add(Asset.bomb.crop(852, 7, 207, 196));
        frames.add(Asset.bomb.crop(1054, 7, 207, 196));
    }

    @Override
    public void tick()
    {
        long now = System.currentTimeMillis();

        // The bomb will be deleted if the time is up
        if (now - createdTime >= timer) {
            Helper.event(new PlusExplosionEvent(handler, explosion, this, 2 * width, 2 * height, range));
            deleted = true;
        }
        else {
            super.tick();
        }
    }
}
