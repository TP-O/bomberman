package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.entities.dynamics.characters.monster.Monster;

public class Scorbunny extends Monster {

    public Scorbunny(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 1;
        health = 1;
        speed = 1.2f;
        damage = 25;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("scorbunny").crop(12, 90, 56, 58));
        upFrames.add(Asset.get("scorbunny").crop(91, 90, 56, 58));

        downFrames.add(Asset.get("scorbunny").crop(12, 11, 56, 58));
        downFrames.add(Asset.get("scorbunny").crop(92, 11, 56, 58));

        leftFrames.add(Asset.get("scorbunny").crop(12, 172, 56, 58));
        leftFrames.add(Asset.get("scorbunny").crop(90, 171, 56, 58));

        rightFrames.add(Asset.get("scorbunny").crop(8, 250, 56, 58));
        rightFrames.add(Asset.get("scorbunny").crop(87, 250, 56, 58));

        standFrames.add(Asset.get("scorbunny").crop(12, 11, 56, 58));
    }
}
