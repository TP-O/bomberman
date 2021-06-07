package components.entities.statics.items.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;
import components.entities.statics.items.Item;

public class HealPotion extends Item {

    private final int VALUE = 10;

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        width = 32;
        height = 68;
        timer = 10000;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("heal-potion").crop(22, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(538, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(1052, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(1584, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(2118, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(2646, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(3202, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(3736, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(4304, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(4886, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(5500, 48, 232, 488));
        frames.add(Asset.get("heal-potion").crop(6054, 48, 232, 488));
    }

    @Override
    public void boost(Player player) {
        // Healing
        player.setHealth(player.getHealth() + VALUE);

        // Delete item
        delete();
    }
}
