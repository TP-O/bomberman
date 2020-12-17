package components.entities.dynamic;

import components.actions.move.Move;
import components.entities.Entity;
import components.entities.constract.Movable;
import core.Handler;

public abstract class DynamicEntity extends Entity implements Movable
{
    protected Move move;

    protected float speed;

    public DynamicEntity(Handler handler)
    {
        super(handler);
    }

    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    @Override
    public void move()
    {
        move.move();
    }

    @Override
    public void tick()
    {
        move();
        
        currentFrame = move.getCurrentImage();
    }

    protected abstract void setActions();
}
