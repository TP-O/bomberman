package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionF extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion06").crop(44, 35, 251, 258));
        frames.add(Asset.get("explosion06").crop(359, 35, 251, 258));
        frames.add(Asset.get("explosion06").crop(695, 35, 251, 258));
        frames.add(Asset.get("explosion06").crop(36, 370, 251, 258));
        frames.add(Asset.get("explosion06").crop(376, 370, 251, 258));
        frames.add(Asset.get("explosion06").crop(705, 370, 251, 258));
        frames.add(Asset.get("explosion06").crop(34, 704, 251, 258));
        frames.add(Asset.get("explosion06").crop(361, 704, 251, 258));
        frames.add(Asset.get("explosion06").crop(691, 704, 251, 258));
    }
}
