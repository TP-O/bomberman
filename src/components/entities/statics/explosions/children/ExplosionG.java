package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionG extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion07").crop(86, 127, 175, 165));
        frames.add(Asset.get("explosion07").crop(298, 127, 175, 165));
        frames.add(Asset.get("explosion07").crop(512, 127, 175, 165));
        frames.add(Asset.get("explosion07").crop(726, 127, 175, 165));
        frames.add(Asset.get("explosion07").crop(99, 357, 175, 165));
        frames.add(Asset.get("explosion07").crop(311, 357, 175, 165));
        frames.add(Asset.get("explosion07").crop(528, 357, 175, 165));
        frames.add(Asset.get("explosion07").crop(730, 357, 175, 165));
    }
}
