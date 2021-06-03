package app.models;

import org.json.simple.JSONObject;

import components.entities.statics.blocks.Block;
import factories.block.BasicBlockFactory;
import factories.block.BlockFactory;

public class BlockModel extends Model<Block> {

    private BlockFactory factory = new BasicBlockFactory();

    @Override
    protected void set() {
        table = "res/data/block.json";
    }

    @Override
    protected void parseObject(JSONObject obstacle) {
        listData.add(factory.createBlock((String) obstacle.get("type"),
                Float.parseFloat(String.valueOf((double) obstacle.get("x"))),
                Float.parseFloat(String.valueOf((double) obstacle.get("y")))));
    }
}
