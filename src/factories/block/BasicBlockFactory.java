package factories.block;

import components.entities.statics.blocks.Block;
import components.entities.statics.blocks.children.GlassBlock;
import components.entities.statics.blocks.children.IronBlock;
import components.entities.statics.blocks.children.WoodBlock;

public class BasicBlockFactory implements BlockFactory {

    @Override
    public Block createBlock(String type, float x, float y) {
        Block block = null;

        switch (type) {
            case "Wood":
                block = new WoodBlock(x, y);
                break;

            case "Iron":
                block = new IronBlock(x, y);
                break;

            case "Glass":
                block = new GlassBlock(x, y);
                break;

            default:
                block = null;
        }

        return block;
    }
}
