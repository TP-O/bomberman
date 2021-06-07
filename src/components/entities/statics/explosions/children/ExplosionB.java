package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionB extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion02").crop(0, 44, 249, 237));
        frames.add(Asset.get("explosion02").crop(182, 44, 249, 237));
        frames.add(Asset.get("explosion02").crop(430, 44, 249, 237));
        frames.add(Asset.get("explosion02").crop(720, 44, 249, 237));
        frames.add(Asset.get("explosion02").crop(996, 44, 249, 237));
        frames.add(Asset.get("explosion02").crop(40, 400, 249, 237));
        frames.add(Asset.get("explosion02").crop(299, 400, 249, 237));
        frames.add(Asset.get("explosion02").crop(555, 400, 249, 237));
        frames.add(Asset.get("explosion02").crop(795, 400, 249, 237));
        frames.add(Asset.get("explosion02").crop(1023, 400, 249, 237));
    }
}
