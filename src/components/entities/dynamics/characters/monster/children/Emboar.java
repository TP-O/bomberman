package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.entities.dynamics.characters.monster.Monster;

public class Emboar extends Monster {

    public Emboar(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 16;
        health = 16;
        speed = 1.0f;
        damage = 7;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("shinyzygarde").crop(0, 2898, 852, 943));
        upFrames.add(Asset.get("shinyzygarde").crop(952, 2884, 852, 943));
        upFrames.add(Asset.get("shinyzygarde").crop(1918, 2891, 852, 943));

        downFrames.add(Asset.get("shinyzygarde").crop(0, 0, 852, 951));
        downFrames.add(Asset.get("shinyzygarde").crop(961, 0, 852, 951));
        downFrames.add(Asset.get("shinyzygarde").crop(1913, 0, 852, 951));

        leftFrames.add(Asset.get("shinyzygarde").crop(64, 980, 852, 971));
        leftFrames.add(Asset.get("shinyzygarde").crop(1037, 966, 852, 943));
        leftFrames.add(Asset.get("shinyzygarde").crop(1967, 987, 852, 943));

        rightFrames.add(Asset.get("shinyzygarde").crop(0, 1917, 852, 943));
        rightFrames.add(Asset.get("shinyzygarde").crop(916, 1917, 852, 943));
        rightFrames.add(Asset.get("shinyzygarde").crop(1917, 1938, 852, 943));

        standFrames.add(Asset.get("shinyzygarde").crop(0, 0, 852, 951));
    }
}
