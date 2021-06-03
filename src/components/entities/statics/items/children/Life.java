package components.entities.statics.items.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;
import components.entities.statics.items.Item;

public class Life extends Item {

    private final int VALUE = 20;

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        width = 32;
        height = 32;
        timer = 5000;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("life").crop(1, 7, 72, 72));
        frames.add(Asset.get("life").crop(84, 7, 72, 72));
        frames.add(Asset.get("life").crop(161, 7, 72, 72));
        frames.add(Asset.get("life").crop(243, 7, 72, 72));
        frames.add(Asset.get("life").crop(316, 7, 72, 72));
        frames.add(Asset.get("life").crop(390, 7, 72, 72));
        frames.add(Asset.get("life").crop(472, 7, 72, 72));
        frames.add(Asset.get("life").crop(550, 7, 72, 72));
        frames.add(Asset.get("life").crop(628, 7, 72, 72));
        frames.add(Asset.get("life").crop(709, 7, 72, 72));
        frames.add(Asset.get("life").crop(791, 7, 72, 72));
        frames.add(Asset.get("life").crop(876, 7, 72, 72));
        frames.add(Asset.get("life").crop(962, 7, 72, 72));
        frames.add(Asset.get("life").crop(1031, 7, 72, 72));
        frames.add(Asset.get("life").crop(1111, 7, 72, 72));
        frames.add(Asset.get("life").crop(1187, 7, 72, 72));
        frames.add(Asset.get("life").crop(1271, 7, 72, 72));
    }

    @Override
    public void boost(Player player) {
        // Increase life
        player.setLife(player.getLife() + VALUE);

        // Delete item
        delete();
    }
}
