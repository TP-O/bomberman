package components.collision;

import components.entities.Entity;
import helper.Helper;

public class EntityCollision implements Collision
{
    private Entity entity;

    private Entity colliedEntity;

    public EntityCollision(Entity entity, Entity colliedEntity)
    {
        this.entity = entity;
        this.colliedEntity = colliedEntity;
    }

    @Override
    public boolean collied()
    {
        return Helper.checkOverlap(
                colliedEntity.getX(),
                colliedEntity.getY(),
                colliedEntity.getWidth(),
                colliedEntity.getHeight(),
                entity.getX(),
                entity.getY(),
                entity.getWidth(),
                entity.getHeight());
    }

    @Override
    public boolean collideTop()
    {
        throw new IllegalAccessError("Unsupport this method!");
    }

    @Override
    public boolean collideBottom()
    {
        throw new IllegalAccessError("Unsupport this method!");
    }

    @Override
    public boolean collideLeft()
    {
        throw new IllegalAccessError("Unsupport this method!");
    }

    @Override
    public boolean collideRight()
    {
        throw new IllegalAccessError("Unsupport this method!");
    }

    @Override
    public void setTarget(Object obj)
    {
        colliedEntity = (Entity) obj;
    }
}
