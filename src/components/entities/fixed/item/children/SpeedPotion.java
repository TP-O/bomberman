package components.entities.fixed.item.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.dynamic.character.player.Player;
import components.entities.fixed.item.Item;

import java.awt.image.BufferedImage;
public class SpeedPotion extends Item
{
    public SpeedPotion(Handler handler)
    {
        super(handler);
    }
    
    @Override
    protected void setEntityParameters()
    {
        width = 32;
        height = 37;
        deleted = false;
        timer = 5000;
    }  

    @Override
    protected void loadAllFrames()
    {
        frames = new ArrayList<BufferedImage>();

        frames.add(Asset.speedBoost.crop(6, 18, 126, 143));
        frames.add(Asset.speedBoost.crop(136, 18, 126, 143));
        frames.add(Asset.speedBoost.crop(267, 18, 126, 143));
        frames.add(Asset.speedBoost.crop(399, 18, 126, 143));
        frames.add(Asset.speedBoost.crop(531, 18, 126, 143));
        frames.add(Asset.speedBoost.crop(671, 18, 126, 143));
        frames.add(Asset.speedBoost.crop(809, 18, 126, 143));
        frames.add(Asset.speedBoost.crop(945, 18, 126, 143));
    }

    @Override
    public void boost(Player entity)
    {
        super.boost(entity);
        
        entity.setSpeed(entity.getSpeed() + 10);
    }
}
