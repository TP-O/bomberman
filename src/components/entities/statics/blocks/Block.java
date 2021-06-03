package components.entities.statics.blocks;

import components.actions.drop.Drop;
import components.actions.drop.DropAcction;
import components.actions.drop.random.RandomItemDrop;
import components.entities.statics.StaticEntity;
import config.TileConfig;

public abstract class Block extends StaticEntity {

    protected Drop drop;

    public Block(float x, float y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected void setEntityParameters() {
        margin = 0;
        padding = 0;
        width = TileConfig.WIDTH;
        height = TileConfig.HEIGHT;
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        drop = new DropAcction(this);
        drop = new RandomItemDrop(drop, 3);
    }

    @Override
    public void delete() {
        super.delete();

        // Leave a souvenir :'(
        drop.drop();
    }
}
