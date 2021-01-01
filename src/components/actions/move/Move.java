package components.actions.move;

import components.animations.MoveAnimation;
import components.collisions.Collision;
import components.collisions.TileCollision;
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

        collision = new TileCollision(entity);
        animation = new MoveAnimation(entity, 250);
    }

    public void moveUp()
    {
        if (!collision.collideTop()) {
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
        if (!collision.collideBottom()) {
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
        if (!collision.collideLeft()) {
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
        if (!collision.collideRight()) {
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
