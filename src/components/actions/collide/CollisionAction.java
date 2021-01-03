package components.actions.collide;

import components.entities.Entity;

public class CollisionAction extends Collision
{
    public CollisionAction()
    {
        super();
    }

    public CollisionAction(Entity entity)
    {
        super(entity);
    }

    @Override
    public boolean isCollided()
    {
        return false;
    }

    @Override
    public boolean isCollidedTop()
    {
        return false;
    }

    @Override
    public boolean isCollidedBottom()
    {
        return false;
    }

    @Override
    public boolean isCollidedLeft()
    {
        return false;
    }

    @Override
    public boolean isCollidedRight()
    {
        return false;
    }
}
