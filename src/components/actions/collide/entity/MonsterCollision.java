package components.actions.collide.entity;

import components.actions.collide.Collision;

public class MonsterCollision extends EntityCollisionDecorator {

    public MonsterCollision(Collision collision) {
        super(collision);

        this.entityType = "monster";
    }
}
