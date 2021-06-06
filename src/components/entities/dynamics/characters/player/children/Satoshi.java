package components.entities.dynamics.characters.player.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;

public class Satoshi extends Player {

    public Satoshi(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 30;
        health = 30;
        speed = 4.5f;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("satoshi").crop(75, 199, 40, 55));
        upFrames.add(Asset.get("satoshi").crop(11, 199, 40, 55));
        upFrames.add(Asset.get("satoshi").crop(203, 199, 40, 55));
        upFrames.add(Asset.get("satoshi").crop(11, 199, 40, 55));

        downFrames.add(Asset.get("satoshi").crop(75, 8, 40, 55));
        downFrames.add(Asset.get("satoshi").crop(11, 8, 40, 55));
        downFrames.add(Asset.get("satoshi").crop(203, 8, 40, 55));
        downFrames.add(Asset.get("satoshi").crop(11, 8, 40, 55));

        leftFrames.add(Asset.get("satoshi").crop(77, 71, 40, 55));
        leftFrames.add(Asset.get("satoshi").crop(13, 71, 40, 55));
        leftFrames.add(Asset.get("satoshi").crop(205, 71, 40, 55));
        leftFrames.add(Asset.get("satoshi").crop(13, 71, 40, 55));

        rightFrames.add(Asset.get("satoshi").crop(75, 135, 40, 55));
        rightFrames.add(Asset.get("satoshi").crop(11, 135, 40, 55));
        rightFrames.add(Asset.get("satoshi").crop(203, 135, 40, 55));
        rightFrames.add(Asset.get("satoshi").crop(11, 135, 40, 55));

        standFrames.add(Asset.get("satoshi").crop(13, 11, 40, 55));
    }
}
