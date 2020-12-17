package components.entities.statics.items.children;

import asset.Asset;
import components.entities.dynamics.character.player.Player;
import components.entities.statics.items.Item;

public class DamagePotion extends Item
{
    private final int VALUE = 5;

    @Override
    protected void setEntityParameters()
    {
        width = 32;
        height = 45;
        timer = 10000;     
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

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
    public void boost(Player player)
    {
        // Increase explosion's damage
        player.getBomb().getExplosion().setDamage(
                    player.getBomb().getExplosion().getDamage() + VALUE);

        // Delete item
        delete();
    }
}
