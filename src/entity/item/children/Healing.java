package entity.item.children;

import entity.item.Item;
import java.util.ArrayList;
import asset.Asset;
import core.main.Handler;
import java.awt.image.BufferedImage;

public class Healing extends Item
{
    public Healing(Handler handler)
    {
        super(handler);
    }
    
    @Override
    protected void loadItemImage()
    {
        images = new ArrayList<BufferedImage>();

        images.add(Asset.heal.crop(321, 155, 100, 89));
        images.add(Asset.heal.crop(321, 156, 100, 100));
        images.add(Asset.heal.crop(321, 168, 100, 89));
        images.add(Asset.heal.crop(321, 156, 100, 100));
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

        // The item will be deleted if the time is up or the item is picked up
        if (now - createdTime >= timer || count == PICK_UP) {
            deleted = true;
        }
        else {
            super.tick();
        }
    }
}