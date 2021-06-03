package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionE extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion05").crop(0, 28, 137, 150));
        frames.add(Asset.get("explosion05").crop(117, 0, 157, 150));
        frames.add(Asset.get("explosion05").crop(273, 0, 157, 150));
        frames.add(Asset.get("explosion05").crop(447, 27, 157, 150));
        frames.add(Asset.get("explosion05").crop(43, 226, 157, 177));
        frames.add(Asset.get("explosion05").crop(237, 210, 157, 184));
        frames.add(Asset.get("explosion05").crop(434, 210, 144, 184));
    }
}
