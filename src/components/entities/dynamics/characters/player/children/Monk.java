package components.entities.dynamics.characters.player.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;

public class Monk extends Player {

    public Monk(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 60;
        health = 60;
        speed = 4.5f;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("monk").crop(436, 701, 357, 454));
        upFrames.add(Asset.get("monk").crop(24, 679, 357, 454));
        upFrames.add(Asset.get("monk").crop(1214, 698, 357, 454));
        upFrames.add(Asset.get("monk").crop(24, 679, 357, 454));

        downFrames.add(Asset.get("monk").crop(433, 98, 357, 454));
        downFrames.add(Asset.get("monk").crop(23, 98, 357, 454));
        downFrames.add(Asset.get("monk").crop(1212, 98, 357, 454));
        downFrames.add(Asset.get("monk").crop(23, 98, 357, 454));

        leftFrames.add(Asset.get("monk").crop(423, 1272, 357, 454));
        leftFrames.add(Asset.get("monk").crop(29, 1273, 357, 454));
        leftFrames.add(Asset.get("monk").crop(423, 1272, 357, 454));
        leftFrames.add(Asset.get("monk").crop(29, 1273, 357, 454));

        rightFrames.add(Asset.get("monk").crop(24, 1876, 357, 454));
        rightFrames.add(Asset.get("monk").crop(419, 1873, 357, 454));
        rightFrames.add(Asset.get("monk").crop(24, 1876, 357, 454));
        rightFrames.add(Asset.get("monk").crop(419, 1873, 357, 454));

        standFrames.add(Asset.get("monk").crop(23, 98, 357, 454));
    }
}
