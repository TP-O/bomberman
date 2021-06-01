package components.actions.collide.tile;

import components.actions.collide.Collision;
import components.actions.collide.CollisionDecorator;

public abstract class TileCollisionDecorator extends CollisionDecorator {

    public TileCollisionDecorator(Collision collision) {
        super(collision);
    }

    @Override
    public boolean isCollided() {
        if (!collision.isCollided()) {
            return isCollidedTop() || isCollidedBottom() || isCollidedLeft() || isCollidedRight();
        }

        return true;
    }

    @Override
    public boolean isCollidedTop() {
        if (!collision.isCollidedTop()) {
            boolean upperLeftCornerCollied = inTile(
                    getEntity().getX() + getEntity().getPadding(),
                    getEntity().getY() + getEntity().getPadding() - getEntity().getMargin());

            boolean upperRightCornerCollied = inTile(
                    getEntity().getX() + getEntity().getWidth() - getEntity().getPadding(),
                    getEntity().getY() + getEntity().getPadding() - getEntity().getMargin());

            return isStrict()
                    ? upperLeftCornerCollied && upperRightCornerCollied
                    : upperLeftCornerCollied || upperRightCornerCollied;
        }

        return true;
    }

    @Override
    public boolean isCollidedBottom() {
        if (!collision.isCollidedBottom()) {
            boolean lowerLeftCornerCollied = inTile(
                    getEntity().getX() + getEntity().getPadding(),
                    getEntity().getY() + getEntity().getHeight() - getEntity().getPadding() + getEntity().getMargin());

            boolean lowerRightCornerCollied = inTile(
                    getEntity().getX() + getEntity().getWidth() - getEntity().getPadding(),
                    getEntity().getY() + getEntity().getHeight() - getEntity().getPadding() + getEntity().getMargin());

            return isStrict()
                    ? lowerLeftCornerCollied && lowerRightCornerCollied
                    : lowerLeftCornerCollied || lowerRightCornerCollied;
        }

        return true;
    }

    @Override
    public boolean isCollidedLeft() {
        if (!collision.isCollidedLeft()) {
            boolean upperLeftCornerCollied = inTile(
                    getEntity().getX() + getEntity().getPadding()- getEntity().getMargin(),
                    getEntity().getY() + getEntity().getPadding());

            boolean lowerLeftCornerCollied = inTile(
                    getEntity().getX() + getEntity().getPadding() - getEntity().getMargin(),
                    getEntity().getY() + getEntity().getHeight() - getEntity().getPadding());

            return isStrict()
                    ? upperLeftCornerCollied && lowerLeftCornerCollied
                    : upperLeftCornerCollied || lowerLeftCornerCollied;
        }

        return true;
    }

    @Override
    public boolean isCollidedRight() {
        if (!collision.isCollidedRight()) {
            boolean upperRightCornerCollied = inTile(
                    getEntity().getX() + getEntity().getWidth() - getEntity().getPadding() + getEntity().getMargin(),
                    getEntity().getY() + getEntity().getPadding());

            boolean lowerRightCornerCollied = inTile(
                    getEntity().getX() + getEntity().getWidth() - getEntity().getPadding() + getEntity().getMargin(),
                    getEntity().getY() + getEntity().getHeight() - getEntity().getPadding());

            return isStrict()
                    ? upperRightCornerCollied && lowerRightCornerCollied
                    : upperRightCornerCollied || lowerRightCornerCollied;
        }

        return true;
    }

    protected abstract boolean inTile(float x, float y);
}
