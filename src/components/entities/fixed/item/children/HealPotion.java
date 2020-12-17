package components.entities.fixed.item.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.dynamic.character.player.Player;
import components.entities.fixed.item.Item;

import java.awt.image.BufferedImage;

public class HealPotion extends Item
{
    public HealPotion(Handler handler)
    {
        super(handler);
    }   

    @Override
    protected void setEntityParameters()
    {
        width = 32;
        height = 68;
        deleted = false;
        timer = 10000;
    }

    @Override
    protected void loadAllFrames()
    {
        frames = new ArrayList<BufferedImage>();

        frames.add(Asset.heal.crop(22, 48, 232, 488));
        frames.add(Asset.heal.crop(538, 48, 232, 488));
        frames.add(Asset.heal.crop(1052, 48, 232, 488));
        frames.add(Asset.heal.crop(1584, 48, 232, 488));
        frames.add(Asset.heal.crop(2118, 48, 232, 488));
        frames.add(Asset.heal.crop(2646, 48, 232, 488));
        frames.add(Asset.heal.crop(3202, 48, 232, 488));
        frames.add(Asset.heal.crop(3736, 48, 232, 488));
        frames.add(Asset.heal.crop(4304, 48, 232, 488));
        frames.add(Asset.heal.crop(4886, 48, 232, 488));
        frames.add(Asset.heal.crop(5500, 48, 232, 488));
        frames.add(Asset.heal.crop(6054, 48, 232, 488));
    }

    @Override
    public void boost(Player entity)
    {
        super.boost(entity);

        entity.setHealth(entity.getHealth() + 10);
    }
}
