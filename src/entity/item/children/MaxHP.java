package entity.item.children;

import entity.item.Item;

import java.util.ArrayList;
import asset.Asset;
import core.main.Handler;
import java.awt.image.BufferedImage;

public class MaxHP extends Item
{
    public MaxHP(Handler handler)
    {
        super(handler);
    }
    
    @Override
    protected void loadItemImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.maxhp.crop(712, 157, 100, 100));
    }

    @Override
    protected void loadDefaultValues()
    {
        width = 32;
        height = 32;
        deleted = false;
        timer = 10000;
    }

    @Override
    public void tick()
    {
        long now = System.currentTimeMillis();

        // The item will be deleted if the time is up
        if (now - createdTime >= timer) {
            deleted = true;
        }
        else {
            super.tick();
        }
    }
}