package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionK extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion10").crop(65, 104, 189, 162));
        frames.add(Asset.get("explosion10").crop(288, 104, 189, 162));
        frames.add(Asset.get("explosion10").crop(516, 104, 189, 162));
        frames.add(Asset.get("explosion10").crop(742, 104, 189, 162));
        frames.add(Asset.get("explosion10").crop(68, 301, 189, 162));
        frames.add(Asset.get("explosion10").crop(294, 301, 189, 162));
        frames.add(Asset.get("explosion10").crop(516, 301, 189, 162));
        frames.add(Asset.get("explosion10").crop(742, 301, 189, 162));
        frames.add(Asset.get("explosion10").crop(64, 497, 189, 162));
        frames.add(Asset.get("explosion10").crop(291, 497, 189, 162));
        frames.add(Asset.get("explosion10").crop(514, 497, 189, 162));
        frames.add(Asset.get("explosion10").crop(726, 497, 189, 162));
    }
}
