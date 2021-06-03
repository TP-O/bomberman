package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.entities.dynamics.characters.monster.Monster;

public class ShinyEmboar extends Monster {

    public ShinyEmboar(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 5;
        health = 5;
        speed = 0.8f;
        damage = 6;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("emboar").crop(2875, 2920, 844, 921));
        upFrames.add(Asset.get("emboar").crop(3827, 2906, 844, 921));
        upFrames.add(Asset.get("emboar").crop(4801, 2913, 844, 921));

        downFrames.add(Asset.get("emboar").crop(2877, 0, 852, 943));
        downFrames.add(Asset.get("emboar").crop(3836, 0, 852, 943));
        downFrames.add(Asset.get("emboar").crop(4795, 0, 852, 943));

        leftFrames.add(Asset.get("emboar").crop(2942, 994, 852, 971));
        leftFrames.add(Asset.get("emboar").crop(3929, 966, 852, 943));
        leftFrames.add(Asset.get("emboar").crop(4829, 973, 852, 943));

        rightFrames.add(Asset.get("emboar").crop(2876, 1953, 816, 900));
        rightFrames.add(Asset.get("emboar").crop(3806, 1925, 816, 921));
        rightFrames.add(Asset.get("emboar").crop(4807, 1953, 816, 921));

        standFrames.add(Asset.get("emboar").crop(0, 0, 852, 951));
    }
}
