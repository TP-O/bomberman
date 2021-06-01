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

        animation = new MovingAnimation(entity, 250);

        collision = new CollisionAction(entity);
    }

    public boolean isCollied() {
        return this.collied;
    }

    public DynamicEntity getEntity() {
        return this.entity;
    }

    public Collision getCollision() {
        return this.collision;
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    public void moveUp() {
        if (!collision.isCollidedTop()) {
            this.collied = false;

            float y = entity.getY();
            entity.setY(y - entity.getSpeed());
        }
        else {
            this.collied = true;
        }

        animation.up();
    }

    public void moveDown() {
        if (!collision.isCollidedBottom()) {
            this.collied = false;

            float y = entity.getY();
            entity.setY(y + entity.getSpeed());
        }
        else {
            this.collied = true;
        }

        animation.down();
    }

    public void moveLeft() {
        if (!collision.isCollidedLeft()) {
            this.collied = false;

            float x = entity.getX();
            entity.setX(x - entity.getSpeed());
        }
        else {
            this.collied = true;
        }

        animation.left();
    }

    public void moveRight() {
        if (!collision.isCollidedRight()) {
            this.collied = false;

            float x = entity.getX();
            entity.setX(x + entity.getSpeed());
        }
        else {
            this.collied = true;
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
