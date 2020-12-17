package components.entities.fixed.item.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.dynamic.character.player.Player;
import components.entities.fixed.item.Item;

import java.awt.image.BufferedImage;

public class Life extends Item
{
    public Life(Handler handler)
    {
        super(handler);
    }

    @Override
    protected void setEntityParameters()
    {
        width = 32;
        height = 32;
        deleted = false;
        timer = 5000;
    }

    @Override
    protected void loadAllFrames()
    {
        frames = new ArrayList<BufferedImage>();

        frames.add(Asset.maxHP.crop(1, 7, 72, 72));
        frames.add(Asset.maxHP.crop(84, 7, 72, 72));
        frames.add(Asset.maxHP.crop(161, 7, 72, 72));
        frames.add(Asset.maxHP.crop(243, 7, 72, 72));
        frames.add(Asset.maxHP.crop(316, 7, 72, 72));
        frames.add(Asset.maxHP.crop(390, 7, 72, 72));
        frames.add(Asset.maxHP.crop(472, 7, 72, 72));
        frames.add(Asset.maxHP.crop(550, 7, 72, 72));
        frames.add(Asset.maxHP.crop(628, 7, 72, 72));
        frames.add(Asset.maxHP.crop(709, 7, 72, 72));
        frames.add(Asset.maxHP.crop(791, 7, 72, 72));
        frames.add(Asset.maxHP.crop(876, 7, 72, 72));
        frames.add(Asset.maxHP.crop(962, 7, 72, 72));
        frames.add(Asset.maxHP.crop(1031, 7, 72, 72));
        frames.add(Asset.maxHP.crop(1111, 7, 72, 72));
        frames.add(Asset.maxHP.crop(1187, 7, 72, 72));
        frames.add(Asset.maxHP.crop(1271, 7, 72, 72));
    }

    @Override
    public void boost(Player entity)
    {
        super.boost(entity);

        entity.setMaxHealth(entity.getMaxHealth() + 15);
    }
}
