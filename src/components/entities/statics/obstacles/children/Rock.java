package components.entities.statics.obstacles.children;

import asset.Asset;
import components.entities.statics.obstacles.Obstacle;

public class Rock extends Obstacle {

    public Rock(float x, float y) {
        super(x, y);
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("rock").crop(9, 35, 240, 221));
    }
}
