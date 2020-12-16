package components.actions.collide;

import components.entities.Entity;
import core.Map;
import helper.Helper;

public class TileCollision implements Collision
{
    private Map map;

    private Entity entity;

    public TileCollision(Entity entity, Map map)
    {
        this.map = map;
        this.entity = entity;
    }

    @Override
    public boolean collideTop()
    {
        boolean upperLeftCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getPadding()),
                Helper.getYOfTile(entity.getY() + entity.getPadding() - entity.getMargin()));

        boolean upperRightCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getWidth() - entity.getPadding()),
                Helper.getYOfTile(entity.getY() + entity.getPadding() - entity.getMargin()));

        return upperLeftCornerCollied || upperRightCornerCollied;
    }

    @Override
    public boolean collideBottom()
    {
        boolean lowerLeftCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getPadding()),
                Helper.getYOfTile(entity.getY() + entity.getHeight() - entity.getPadding() + entity.getMargin()));

        boolean lowerRightCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getWidth() - entity.getPadding()),
                Helper.getYOfTile(entity.getY() + entity.getHeight() - entity.getPadding() + entity.getMargin()));

        return lowerLeftCornerCollied || lowerRightCornerCollied;
    }

    @Override
    public boolean collideLeft()
    {
        boolean upperLeftCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getPadding()- entity.getMargin()),
                Helper.getYOfTile(entity.getY() + entity.getPadding()));

        boolean lowerLeftCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getPadding() - entity.getMargin()),
                Helper.getYOfTile(entity.getY() + entity.getHeight() - entity.getPadding()));

        return upperLeftCornerCollied || lowerLeftCornerCollied;
    }

    @Override
    public boolean collideRight()
    {
        boolean upperRightCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getWidth() - entity.getPadding() + entity.getMargin()),
                Helper.getYOfTile(entity.getY() + entity.getPadding()));

        boolean lowerRightCornerCollied = isCollied(
                Helper.getXOfTile(entity.getX() + entity.getWidth() - entity.getPadding() + entity.getMargin()),
                Helper.getYOfTile(entity.getY() + entity.getHeight() - entity.getPadding()));

        return upperRightCornerCollied || lowerRightCornerCollied;
    }

    @Override
    public void setTarget(Object obj)
    {
        throw new Error("Unsupport this method");
    }

    public boolean isCollied(int x, int y)
    {
        return map
            .getTiles(x, y)
            .isSolid();
    }
}
