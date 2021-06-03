package factories.block;

import components.entities.statics.blocks.Block;

public interface BlockFactory {
    public Block createBlock(String type, float x, float y);
}
