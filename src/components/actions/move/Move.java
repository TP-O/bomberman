package components.actions.move;

import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.animations.MovingAnimation;
import components.entities.dynamics.DynamicEntity;

public abstract class Move {

    private boolean collied;

    private Collision collision;

    private MovingAnimation animation;

    private DynamicEntity entity;

    public Move(DynamicEntity entity) {
        this.entity = entity;

        this.animation = new MovingAnimation(entity, 250);
        this.collision = new CollisionAction(entity);
    }

    public boolean isCollied() {
        return collied;
    }

    public DynamicEntity getEntity() {
        return entity;
    }

    public Collision getCollision() {
        return collision;
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    public void moveUp() {
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

    public void moveDown() {
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

    public void moveLeft() {
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

    public void moveRight() {
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

    public void stand() {
        animation.stand();
    }

    public void changeAnimation() {
        animation.tick();
    }

    public abstract void move();
}
