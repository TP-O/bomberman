package components.actions.collide.entity;

import components.actions.collide.Collision;

public class BombCollision extends EntityCollisionDecorator {

    public BombCollision(Collision collision) {
        super(collision);

        this.entityType = "bomb";
    }
}
