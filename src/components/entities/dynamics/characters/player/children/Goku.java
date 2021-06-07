package components.entities.dynamics.characters.player.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;

public class Goku extends Player {

    public Goku(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 100;
        health = 100;
        speed = 3.0f;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("goku").crop(77, 192, 43, 64));
        upFrames.add(Asset.get("goku").crop(13, 194, 43, 62));
        upFrames.add(Asset.get("goku").crop(205, 192, 43, 64));
        upFrames.add(Asset.get("goku").crop(13, 194, 43, 62));

        downFrames.add(Asset.get("goku").crop(73, 1, 42, 64));
        downFrames.add(Asset.get("goku").crop(9, 3, 43, 64));
        downFrames.add(Asset.get("goku").crop(201, 1, 41, 64));
        downFrames.add(Asset.get("goku").crop(9, 3, 43, 64));

        leftFrames.add(Asset.get("goku").crop(73, 64, 43, 62));
        leftFrames.add(Asset.get("goku").crop(9, 67, 43, 62));
        leftFrames.add(Asset.get("goku").crop(201, 64, 43, 62));
        leftFrames.add(Asset.get("goku").crop(9, 67, 43, 62));

        rightFrames.add(Asset.get("goku").crop(77, 127, 43, 64));
        rightFrames.add(Asset.get("goku").crop(13, 131, 43, 62));
        rightFrames.add(Asset.get("goku").crop(205, 127, 43, 64));
        rightFrames.add(Asset.get("goku").crop(13, 131, 43, 62));

        standFrames.add(Asset.get("goku").crop(9, 3, 43, 62));
    }
}
