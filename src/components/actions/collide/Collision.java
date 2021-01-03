package components.actions.collide;

import java.util.ArrayList;
import java.util.List;

import components.entities.Entity;

public abstract class Collision
{
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

    protected boolean strict;

    protected Entity entity;

    protected Entity collidedEntity;

    protected List<Entity> collidedEntities;

    public Collision()
    {
        collidedEntities = new ArrayList<Entity>();
    }

    public Collision(Entity entity)
    {
        this.entity = entity;

        collidedEntities = new ArrayList<Entity>();
    }

    public boolean isStrict()
    {
        return strict;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public Entity getCollidedEntity()
    {
        return collidedEntity;
    }

    public List<Entity> getCollidedEntities()
    {
        return collidedEntities;
    }

    public void useStrictMode()
    {
        strict = true;
    }

    public void setEntity(Entity entity)
    {
        this.entity = entity;
    }

    public void setCollidedEntity(Entity collidedEntity)
    {
        this.collidedEntity = collidedEntity;
    }

    public void clearCollidedEntities()
    {
        collidedEntities.clear();
    }

    public abstract boolean isCollided();

    public abstract boolean isCollidedTop();

    public abstract boolean isCollidedBottom();

    public abstract boolean isCollidedLeft();

    public abstract boolean isCollidedRight();
}
