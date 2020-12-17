package components.entities.fixed.item.children;

import java.util.ArrayList;

import asset.Asset;
import core.Handler;
import components.entities.dynamic.character.player.Player;
import components.entities.fixed.item.Item;

import java.awt.image.BufferedImage;

public class DamagePotion extends Item
{
    public DamagePotion(Handler handler)
    {
        super(handler);
    }
    
    @Override
    protected void setEntityParameters()
    {
        width = 32;
        height = 45;
        deleted = false;      
        timer = 10000;     
    }

    @Override
    protected void loadAllFrames()
    {
        frames = new ArrayList<BufferedImage>();

        frames.add(Asset.damageBoost.crop(4, 7, 116, 164));
        frames.add(Asset.damageBoost.crop(120, 7, 116, 164));
        frames.add(Asset.damageBoost.crop(234, 7, 116, 164));
        frames.add(Asset.damageBoost.crop(347, 7, 116, 164));
        frames.add(Asset.damageBoost.crop(464, 7, 116, 164));
        frames.add(Asset.damageBoost.crop(582, 7, 116, 164));
        frames.add(Asset.damageBoost.crop(698, 7, 116, 164));
        frames.add(Asset.damageBoost.crop(816, 7, 116, 164));
    }

    @Override
    public void boost(Player entity)
    {
        super.boost(entity);

        entity.getBomb().getExplosion().setDamage(entity.getBomb().getExplosion().getDamage() + 5);
    }
}
