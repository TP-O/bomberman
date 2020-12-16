package components.actions.collide;

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
    public boolean collideTop()
    {
        boolean upperLeftCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        boolean upperRightCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getWidth() - colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        return upperLeftCornerCollied || upperRightCornerCollied;
    }

    @Override
    public boolean collideBottom()
    {
        boolean lowerLeftCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getHeight() - colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        boolean lowerRightCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getWidth() - colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getHeight() - colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        return lowerLeftCornerCollied || lowerRightCornerCollied;
    }

    @Override
    public boolean collideLeft()
    {
        boolean upperLeftCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        boolean lowerLeftCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getHeight() - colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        return upperLeftCornerCollied || lowerLeftCornerCollied;
    }

    @Override
    public boolean collideRight()
    {
        boolean upperRightCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getWidth() - colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        boolean lowerRightCornerCollied = Helper.inSquare(
                colliedEntity.getX() + colliedEntity.getWidth() - colliedEntity.getPadding(),
                colliedEntity.getY() + colliedEntity.getHeight() - colliedEntity.getPadding(),
                entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());

        return upperRightCornerCollied || lowerRightCornerCollied;
    }

    @Override
    public void setTarget(Object obj)
    {
        colliedEntity = (Entity) obj;
    }
}
