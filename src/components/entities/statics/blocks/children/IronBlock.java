package components.entities.statics.blocks.children;

import asset.Asset;
import components.entities.statics.blocks.Block;

public class IronBlock extends Block {

    public IronBlock(float x, float y) {
        super(x, y);
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("block01").crop(138, 35, 122, 136));
    }
}
