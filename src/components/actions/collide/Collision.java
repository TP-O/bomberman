package components.actions.collide;

import java.util.List;

import components.entities.Entity;

public interface Collision {
    /**
     *            Top
     *        *--------*
     *         |______|
     *     *|--|      |--|*
     * Left |  |      |  | Right
     *      |--|______|--|
     *     *   |      |   *
     *        *--------*
     *          Bottom
     */

    public boolean isStrict();

    public Entity getEntity();

    public Entity getCollidedEntity();

    public List<Entity> getCollidedEntities();

    public void useStrictMode();

    public void setEntity(Entity entity);

    public void setCollidedEntity(Entity collidedEntity);

    public void clearCollidedEntities();

    public abstract boolean isCollided();

    public abstract boolean isCollidedTop();

    public abstract boolean isCollidedBottom();

    public abstract boolean isCollidedLeft();

    public abstract boolean isCollidedRight();
}
