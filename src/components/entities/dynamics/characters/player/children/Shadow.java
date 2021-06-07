package components.entities.dynamics.characters.player.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;

public class Shadow extends Player {

    public Shadow(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 140;
        health = 140;
        speed = 2.8f;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("shadow").crop(77, 192, 42, 64));
        upFrames.add(Asset.get("shadow").crop(13, 192, 42, 64));
        upFrames.add(Asset.get("shadow").crop(205, 192, 42, 64));
        upFrames.add(Asset.get("shadow").crop(13, 192, 42, 64));

        downFrames.add(Asset.get("shadow").crop(77, 0, 42, 64));
        downFrames.add(Asset.get("shadow").crop(13, 0, 42, 64));
        downFrames.add(Asset.get("shadow").crop(205, 0, 42, 64));
        downFrames.add(Asset.get("shadow").crop(13, 0, 42, 64));

        leftFrames.add(Asset.get("shadow").crop(79, 65, 42, 64));
        leftFrames.add(Asset.get("shadow").crop(15, 65, 42, 64));
        leftFrames.add(Asset.get("shadow").crop(207, 65, 42, 64));
        leftFrames.add(Asset.get("shadow").crop(15, 65, 42, 64));

        rightFrames.add(Asset.get("shadow").crop(75, 129, 42, 64));
        rightFrames.add(Asset.get("shadow").crop(11, 127, 42, 64));
        rightFrames.add(Asset.get("shadow").crop(203, 129, 42, 64));
        rightFrames.add(Asset.get("shadow").crop(11, 127, 42, 64));

        standFrames.add(Asset.get("shadow").crop(13, 0, 42, 64));
    }
}
