package components.collisions;

import components.entities.Entity;
import core.Handler;
import helper.Helper;

public class TileCollision implements Collision
{
    private Entity entity;

    public TileCollision(Entity entity)
    {
        this.entity = entity;
    }

    @Override
    public boolean collied()
    {
        return collideTop() || collideBottom() || collideLeft() || collideRight();
    }

    @Override
    public boolean collideTop()
    {
        boolean upperLeftCornerCollied = isCollied(
                entity.getX() + entity.getPadding(),
                entity.getY() + entity.getPadding() - entity.getMargin());

        boolean upperRightCornerCollied = isCollied(
                entity.getX() + entity.getWidth() - entity.getPadding(),
                entity.getY() + entity.getPadding() - entity.getMargin());

        return upperLeftCornerCollied && upperRightCornerCollied;
    }

    @Override
    public boolean collideBottom()
    {
        boolean lowerLeftCornerCollied = isCollied(
                entity.getX() + entity.getPadding(),
                entity.getY() + entity.getHeight() - entity.getPadding() + entity.getMargin());

        boolean lowerRightCornerCollied = isCollied(
                entity.getX() + entity.getWidth() - entity.getPadding(),
                entity.getY() + entity.getHeight() - entity.getPadding() + entity.getMargin());

        return lowerLeftCornerCollied && lowerRightCornerCollied;
    }

    @Override
    public boolean collideLeft()
    {
        boolean upperLeftCornerCollied = isCollied(
                entity.getX() + entity.getPadding()- entity.getMargin(),
                entity.getY() + entity.getPadding());

        boolean lowerLeftCornerCollied = isCollied(
                entity.getX() + entity.getPadding() - entity.getMargin(),
                entity.getY() + entity.getHeight() - entity.getPadding());

        return upperLeftCornerCollied && lowerLeftCornerCollied;
    }

    @Override
    public boolean collideRight()
    {
        boolean upperRightCornerCollied = isCollied(
                entity.getX() + entity.getWidth() - entity.getPadding() + entity.getMargin(),
                entity.getY() + entity.getPadding());

        boolean lowerRightCornerCollied = isCollied(
                entity.getX() + entity.getWidth() - entity.getPadding() + entity.getMargin(),
                entity.getY() + entity.getHeight() - entity.getPadding());

        return upperRightCornerCollied && lowerRightCornerCollied;
    }

    @Override
    public void setTarget(Object obj)
    {
        entity = (Entity) obj;
    }

    public boolean isCollied(float x, float y)
    {
        return Handler.getInstance().getMap()
                .getTile(Helper.getXOfTile(x), Helper.getYOfTile(y)).isSolid();
    }
}
