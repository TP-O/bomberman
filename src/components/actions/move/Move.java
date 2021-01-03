package components.actions.move;

import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.actions.collide.entity.BlockCollision;
import components.actions.collide.entity.BombCollision;
import components.actions.collide.entity.ObstacleCollision;
import components.actions.collide.tile.SolidTileCollision;
import components.animations.MoveAnimation;
import components.entities.dynamics.DynamicEntity;

public abstract class Move
{
    protected boolean collied;

    private Collision collision;

    private MoveAnimation animation;

    private DynamicEntity entity;

    public Move(DynamicEntity entity)
    {
        this.entity = entity;

        animation = new MoveAnimation(entity, 250);

        collision = new CollisionAction(entity);
        collision = new BombCollision(collision);
        collision = new BlockCollision(collision);
        collision = new ObstacleCollision(collision);
        collision = new SolidTileCollision(collision);
    }

    public void moveUp()
    {
        if (!collision.isCollidedTop()) {
            collied = false;

            float y = entity.getY();
            entity.setY(y - entity.getSpeed());
        }
        else {
            collied = true;
        }

        animation.up();
    }

    public void moveDown()
    {
        if (!collision.isCollidedBottom()) {
            collied = false;

            float y = entity.getY();
            entity.setY(y + entity.getSpeed());
        }
        else {
            collied = true;
        }

        animation.down();
    }

    public void moveLeft()
    {
        if (!collision.isCollidedLeft()) {
            collied = false;

            float x = entity.getX();
            entity.setX(x - entity.getSpeed());
        }
        else {
            collied = true;
        }

        animation.left();
    }

    public void moveRight()
    {
        if (!collision.isCollidedRight()) {
            collied = false;

            float x = entity.getX();
            entity.setX(x + entity.getSpeed());
        }
        else {
            collied = true;
        }

        animation.right();
    }

    public void stand()
    {
        animation.stand();
    }

    public void move()
    {
        animation.tick();
    }
}
