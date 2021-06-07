package components.entities.statics.explosions.children;

import asset.Asset;
import components.entities.statics.explosions.Explosion;

public class ExplosionJ extends Explosion {

    @Override
    protected void setEntityParameters() {
        damage = 5;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("explosion09").crop(46, 172, 137, 126));
        frames.add(Asset.get("explosion09").crop(195, 172, 137, 126));
        frames.add(Asset.get("explosion09").crop(349, 172, 137, 126));
        frames.add(Asset.get("explosion09").crop(505, 172, 137, 126));
        frames.add(Asset.get("explosion09").crop(655, 172, 137, 126));
        frames.add(Asset.get("explosion09").crop(810, 172, 137, 126));
        frames.add(Asset.get("explosion09").crop(48, 312, 137, 126));
        frames.add(Asset.get("explosion09").crop(203, 312, 137, 126));
        frames.add(Asset.get("explosion09").crop(353, 312, 137, 126));
        frames.add(Asset.get("explosion09").crop(492, 312, 137, 126));
        frames.add(Asset.get("explosion09").crop(645, 312, 137, 126));
    }
}
