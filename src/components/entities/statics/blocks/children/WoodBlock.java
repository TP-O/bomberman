package components.entities.statics.blocks.children;

import asset.Asset;
import components.entities.statics.blocks.Block;

public class WoodBlock extends Block {

    public WoodBlock(float x, float y) {
        super(x, y);
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("block01").crop(11, 34, 122, 136));
    }
}
