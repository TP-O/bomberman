package components.actions.collide.tile;

import components.actions.collide.Collision;
import core.Handler;
import helper.Helper;

public class SolidTileCollision extends TileCollisionDecorator {

    public SolidTileCollision(Collision collision) {
        super(collision);
    }

    @Override
    protected boolean inTile(float x, float y) {
        return Handler.getInstance().getMap()
                .getTile(Helper.getXOfTile(x), Helper.getYOfTile(y)).isSolid();
    }
}
