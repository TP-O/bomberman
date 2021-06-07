package components.entities.statics.items.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;
import components.entities.statics.items.Item;

public class SpeedPotion extends Item {

    private final float VALUE = 0.5f;

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        width = 32;
        height = 37;
        timer = 5000;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("speed-potion").crop(6, 18, 126, 143));
        frames.add(Asset.get("speed-potion").crop(136, 18, 126, 143));
        frames.add(Asset.get("speed-potion").crop(267, 18, 126, 143));
        frames.add(Asset.get("speed-potion").crop(399, 18, 126, 143));
        frames.add(Asset.get("speed-potion").crop(531, 18, 126, 143));
        frames.add(Asset.get("speed-potion").crop(671, 18, 126, 143));
        frames.add(Asset.get("speed-potion").crop(809, 18, 126, 143));
        frames.add(Asset.get("speed-potion").crop(945, 18, 126, 143));
    }

    @Override
    public void boost(Player player) {
        // Increase speed
        player.setSpeed(player.getSpeed() + VALUE);

        // Delete item
        delete();
    }
}
