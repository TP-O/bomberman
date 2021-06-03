package components.entities.dynamics.characters.player.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;

public class Kid extends Player {

    public Kid(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 80;
        health = 80;
        speed = 4.0f;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("kid").crop(252, 296, 205, 269));
        upFrames.add(Asset.get("kid").crop(241, 286, 205, 269));
        upFrames.add(Asset.get("kid").crop(513, 296, 205, 269));
        upFrames.add(Asset.get("kid").crop(6, 286, 205, 269));

        downFrames.add(Asset.get("kid").crop(245, 20, 205, 269));
        downFrames.add(Asset.get("kid").crop(2, 10, 205, 269));
        downFrames.add(Asset.get("kid").crop(491, 20, 205, 269));
        downFrames.add(Asset.get("kid").crop(2, 10, 205, 269));

        leftFrames.add(Asset.get("kid").crop(245, 574, 205, 269));
        leftFrames.add(Asset.get("kid").crop(0, 569, 205, 269));
        leftFrames.add(Asset.get("kid").crop(501, 574, 205, 269));
        leftFrames.add(Asset.get("kid").crop(0, 569, 205, 269));

        rightFrames.add(Asset.get("kid").crop(260, 852, 205, 269));
        rightFrames.add(Asset.get("kid").crop(10, 852, 205, 269));
        rightFrames.add(Asset.get("kid").crop(498, 852, 205, 269));
        rightFrames.add(Asset.get("kid").crop(10, 852, 205, 269));

        standFrames.add(Asset.get("kid").crop(2, 10, 205, 269));
    }
}
