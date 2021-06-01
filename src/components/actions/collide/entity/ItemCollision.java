package components.actions.collide.entity;

import components.actions.collide.Collision;

public class ItemCollision extends EntityCollisionDecorator {

    public ItemCollision(Collision collision) {
        super(collision);

        this.entityType = "item";
    }
}
