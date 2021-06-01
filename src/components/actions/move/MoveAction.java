package components.actions.move;

import components.entities.dynamics.DynamicEntity;

public class MoveAction extends Move {

    public MoveAction(DynamicEntity entity) {
        super(entity);
    }

    @Override
    public void move() {
        this.changeAnimation();
    }
}
