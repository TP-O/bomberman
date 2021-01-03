package components.actions.collide.entity;

import components.actions.collide.Collision;

public class PlayerCollision extends EntityCollisionDecorator
{
    public PlayerCollision(Collision collision)
    {
        super(collision);

        entityType = "player";
    }
}
