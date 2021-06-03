package components.entities.dynamics.characters.player.children;

import asset.Asset;
import components.entities.dynamics.characters.player.Player;

public class Kirito extends Player {

    public Kirito(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 120;
        health = 120;
        speed = 2.2f;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("kirito").crop(7, 145, 35, 47));
        upFrames.add(Asset.get("kirito").crop(54, 145, 35, 47));
        upFrames.add(Asset.get("kirito").crop(102, 145, 35, 47));
        upFrames.add(Asset.get("kirito").crop(54, 145, 35, 47));

        downFrames.add(Asset.get("kirito").crop(5, 2, 35, 47));
        downFrames.add(Asset.get("kirito").crop(54, 2, 35, 47));
        downFrames.add(Asset.get("kirito").crop(102, 2, 35, 47));
        downFrames.add(Asset.get("kirito").crop(54, 2, 35, 47));

        leftFrames.add(Asset.get("kirito").crop(5, 51, 35, 47));
        leftFrames.add(Asset.get("kirito").crop(53, 51, 35, 47));
        leftFrames.add(Asset.get("kirito").crop(101, 51, 35, 47));
        leftFrames.add(Asset.get("kirito").crop(53, 51, 35, 47));

        rightFrames.add(Asset.get("kirito").crop(7, 99, 35, 47));
        rightFrames.add(Asset.get("kirito").crop(54, 99, 35, 47));
        rightFrames.add(Asset.get("kirito").crop(103, 99, 35, 47));
        rightFrames.add(Asset.get("kirito").crop(54, 99, 35, 47));

        standFrames.add(Asset.get("kirito").crop(56, 2, 35, 47));
    }
}
