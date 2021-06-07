package components.entities.statics.blocks.children;

import asset.Asset;
import components.entities.statics.blocks.Block;

public class GlassBlock extends Block {

    public GlassBlock(float x, float y) {
        super(x, y);
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("block01").crop(265, 32, 122, 136));
    }
}
