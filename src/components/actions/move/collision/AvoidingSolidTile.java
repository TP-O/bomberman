package components.actions.move.collision;

import components.actions.collide.tile.SolidTileCollision;
import components.actions.move.Move;
import components.actions.move.MoveDecorator;

public class AvoidingSolidTile extends MoveDecorator {

    public AvoidingSolidTile(Move move) {
        super(move);

        this.setCollision(new SolidTileCollision(this.getCollision()));
    }

    @Override
    protected void decorate() {
        //
    }
}
