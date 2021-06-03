package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.entities.dynamics.characters.monster.Monster;

public class AlolanPersian extends Monster {

    public AlolanPersian(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 10;
        health = 10;
        speed = 1.1f;
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("alolanpersian").crop(10, 202, 128, 112));
        upFrames.add(Asset.get("alolanpersian").crop(172, 202, 128, 112));

        downFrames.add(Asset.get("alolanpersian").crop(6, 20, 128, 137));
        downFrames.add(Asset.get("alolanpersian").crop(167, 20, 128, 137));

        leftFrames.add(Asset.get("alolanpersian").crop(20, 371, 137, 112));
        leftFrames.add(Asset.get("alolanpersian").crop(177, 371, 137, 112));

        rightFrames.add(Asset.get("alolanpersian").crop(4, 528, 137, 112));
        rightFrames.add(Asset.get("alolanpersian").crop(168, 528, 137, 112));

        standFrames.add(Asset.get("alolanpersian").crop(6, 20, 128, 137));
    }
}
