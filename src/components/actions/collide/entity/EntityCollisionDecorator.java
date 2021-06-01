package components.actions.collide.entity;

import app.cache.EntityCache;
import components.actions.collide.Collision;
import components.actions.collide.CollisionDecorator;
import components.entities.Entity;

public abstract class EntityCollisionDecorator extends CollisionDecorator {

    protected String entityType = "empty";

    public EntityCollisionDecorator(Collision collision) {
        super(collision);
    }

    @Override
    public boolean isCollided() {
        for (Entity e: EntityCache.get(entityType)) {
            collision.setCollidedEntity(e);

            if (checkCollided()) {
                getCollidedEntities().add(e);
            }
        }

        if (getCollidedEntities().size() > 0) {
            return true;
        }

        return collision.isCollided();
    }

    @Override
    public boolean isCollidedTop() {
        for (Entity e: EntityCache.get(entityType)) {
            collision.setCollidedEntity(e);

            if (checkCollidedTop()) {
                return true;
            }
        }

        return collision.isCollidedTop();
    }

    @Override
    public boolean isCollidedBottom() {
        for (Entity e: EntityCache.get(entityType)) {
            collision.setCollidedEntity(e);

            if (checkCollidedBottom()) {
                return true;
            }
        }

        return collision.isCollidedBottom();
    }

    @Override
    public boolean isCollidedLeft() {
        for (Entity e: EntityCache.get(entityType)) {
            collision.setCollidedEntity(e);

            if (checkCollidedLeft()) {
                return true;
            }
        }

        return collision.isCollidedLeft();
    }

    @Override
    public boolean isCollidedRight() {
        for (Entity e: EntityCache.get(entityType)) {
            collision.setCollidedEntity(e);

            if (checkCollidedRight()) {
                return true;
            }
        }

        return collision.isCollidedRight();
    }

    protected boolean checkCollided() {
        return checkCollidedTop() || checkCollidedBottom() || checkCollidedLeft() || checkCollidedRight();
    }

    protected boolean checkCollidedTop() {
        boolean upperLeftCornerCollied, upperRightCornerCollied;

        upperLeftCornerCollied = getXLeftWithoutMargin() >= getCollidedEntity().getX()
                    && getXLeftWithoutMargin() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                    && getYTop() >= getCollidedEntity().getY()
                    && getYTop() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        upperRightCornerCollied = getXRightWithoutMargin() >= getCollidedEntity().getX()
                    && getXRightWithoutMargin() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                    && getYTop() >= getCollidedEntity().getY()
                    && getYTop() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        return isStrict()
                ? upperLeftCornerCollied && upperRightCornerCollied
                : upperLeftCornerCollied || upperRightCornerCollied;
    }

    protected boolean checkCollidedBottom() {
        boolean lowerLeftCornerCollied, lowerRightCornerCollied;

        lowerLeftCornerCollied = getXLeftWithoutMargin() >= getCollidedEntity().getX()
                    && getXLeftWithoutMargin() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                    && getYBottom() >= getCollidedEntity().getY()
                    && getYBottom() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        lowerRightCornerCollied = getXRightWithoutMargin() >= getCollidedEntity().getX()
                    && getXRightWithoutMargin() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                    && getYBottom() >= getCollidedEntity().getY()
                    && getYBottom() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        return isStrict()
                ? lowerLeftCornerCollied && lowerRightCornerCollied
                : lowerLeftCornerCollied || lowerRightCornerCollied;
    }

    protected boolean checkCollidedLeft() {
        boolean upperLeftCornerCollided, lowerLeftCornerCollided;

        upperLeftCornerCollided = getXLeft() >= getCollidedEntity().getX()
                && getXLeft() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                && getYTopWithoutMargin() >= getCollidedEntity().getY()
                && getYTopWithoutMargin() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        lowerLeftCornerCollided = getXLeft() >= getCollidedEntity().getX()
                && getXLeft() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                && getYBottomWithoutMargin() >= getCollidedEntity().getY()
                && getYBottomWithoutMargin() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        return isStrict()
                ? upperLeftCornerCollided && lowerLeftCornerCollided
                : upperLeftCornerCollided || lowerLeftCornerCollided;
    }

    protected boolean checkCollidedRight() {
        boolean upperRightCornerCollided, lowerRightCornerCollided;

        upperRightCornerCollided = getXRight() >= getCollidedEntity().getX()
                && getXRight() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                && getYTopWithoutMargin() >= getCollidedEntity().getY()
                && getYTopWithoutMargin() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        lowerRightCornerCollided = getXRight() >= getCollidedEntity().getX()
                && getXRight() <= getCollidedEntity().getX() + getCollidedEntity().getWidth()
                && getYBottomWithoutMargin() >= getCollidedEntity().getY()
                && getYBottomWithoutMargin() <= getCollidedEntity().getY() + getCollidedEntity().getHeight();

        return isStrict()
                ? upperRightCornerCollided && lowerRightCornerCollided
                : upperRightCornerCollided || lowerRightCornerCollided;
    }

    private float getYTop() {
        return getEntity().getY() + getEntity().getPadding() - getEntity().getMargin();
    }

    private float getYTopWithoutMargin() {
        return getYTop() + getEntity().getMargin();
    }

    private float getYBottom() {
        return getEntity().getY() + getEntity().getHeight() - getEntity().getPadding() + getEntity().getMargin();
    }

    private float getYBottomWithoutMargin() {
        return getYBottom() - getEntity().getMargin();
    }

    private float getXLeft() {
        return getEntity().getX() + getEntity().getPadding() - getEntity().getMargin();
    }

    private float getXLeftWithoutMargin() {
        return getXLeft() + getEntity().getMargin();
    }

    private float getXRight() {
        return getEntity().getX() + getEntity().getWidth() - getEntity().getPadding() + getEntity().getMargin();
    }

    private float getXRightWithoutMargin() {
        return getXRight() - getEntity().getMargin();
    }
}
