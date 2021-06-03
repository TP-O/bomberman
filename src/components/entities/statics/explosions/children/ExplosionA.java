package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionA extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion01").crop(2, 0, 298, 302));
        frames.add(Asset.get("explosion01").crop(306, 23, 298, 302));
        frames.add(Asset.get("explosion01").crop(641, 9, 298, 302));
        frames.add(Asset.get("explosion01").crop(965, 19, 298, 302));
        frames.add(Asset.get("explosion01").crop(1311, 4, 298, 302));
        frames.add(Asset.get("explosion01").crop(1662, 17, 298, 302));
        frames.add(Asset.get("explosion01").crop(43, 385, 298, 302));
        frames.add(Asset.get("explosion01").crop(394, 387, 298, 302));
        frames.add(Asset.get("explosion01").crop(736, 394, 298, 302));
        frames.add(Asset.get("explosion01").crop(1038, 398, 298, 302));
        frames.add(Asset.get("explosion01").crop(1319, 395, 298, 302));
        frames.add(Asset.get("explosion01").crop(1652, 383, 298, 302));
    }
}
