package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionL extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion11").crop(519, 69, 144, 125));
        frames.add(Asset.get("explosion11").crop(668, 69, 144, 125));
        frames.add(Asset.get("explosion11").crop(840, 69, 144, 125));
        frames.add(Asset.get("explosion11").crop(522, 213, 144, 125));
        frames.add(Asset.get("explosion11").crop(673, 213, 144, 125));
        frames.add(Asset.get("explosion11").crop(834, 213, 144, 125));
        frames.add(Asset.get("explosion11").crop(521, 358, 144, 125));
        frames.add(Asset.get("explosion11").crop(671, 358, 144, 125));
        frames.add(Asset.get("explosion11").crop(840, 358, 144, 125));
    }
}
