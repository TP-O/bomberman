package components.entities.fixed.bomb;

import components.actions.animate.Animation;
import components.entities.fixed.FixedEntity;
import components.entities.fixed.explosion.Explosion;

import java.awt.Graphics;

import core.Handler;

public abstract class Bomb extends FixedEntity implements Cloneable
{
    protected int range;

    protected int timer;

    protected int damage;

    protected long createdTime;

    protected Explosion explosion;

    public Bomb(Handler handler)
    {
        super(handler);

        setEntityParameters();

        loadAllFrames();
        initializeAnimation();
    }

    public Explosion getExplosion()
    {
        return explosion;
    }

    public void setRange(int range)
    {
        this.range = range > 0 ? range : 1;
    }

    public void setCreatedTime(long time)
    {
        createdTime = time;
    }

    @Override
    protected void initializeAnimation()
    {
        animation = new Animation(200, frames);
    }

    @Override
    public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
    }

    @Override
    public void tick()
    {
        animation.tick();
        currentFrame = animation.getCurrentFrame();
    }

    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame,
                (int) (x - handler.getCamera().getXOffset()),
                (int) (y - handler.getCamera().getYOffset()),
                width, height, null);
    }
}
