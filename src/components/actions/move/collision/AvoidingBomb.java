package components.actions.move.collision;

import components.actions.collide.entity.BombCollision;
import components.actions.move.Move;
import components.actions.move.MoveDecorator;

public class AvoidingBomb extends MoveDecorator {

    public AvoidingBomb(Move move) {
        super(move);

        this.setCollision(new BombCollision(this.getCollision()));
    }

    @Override
    protected void decorate() {
        //
    }
}
