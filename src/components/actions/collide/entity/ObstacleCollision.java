package components.actions.collide.entity;

import components.actions.collide.Collision;

public class ObstacleCollision extends EntityCollisionDecorator {

    public ObstacleCollision(Collision collision) {
        super(collision);

        this.entityType = "obstacle";
    }
}
