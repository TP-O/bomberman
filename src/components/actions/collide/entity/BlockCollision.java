package components.actions.collide.entity;

import components.actions.collide.Collision;

public class BlockCollision extends EntityCollisionDecorator {

    public BlockCollision(Collision collision) {
        super(collision);

        this.entityType = "block";
    }
}
