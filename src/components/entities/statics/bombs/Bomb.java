package components.entities.statics.bombs;

import components.behaviors.animate.Animation;
import components.behaviors.attack.AttackBehavior;
import components.entities.statics.StaticEntity;
import components.entities.statics.explosions.Explosion;

public abstract class Bomb extends StaticEntity implements Cloneable
{
    protected int range;

    protected int timer;

    protected long createdTime;

    protected Explosion explosion;

    protected AttackBehavior attack;

    @Override
    protected void initializeActions()
    {
        // Set animation
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
        // Update frame
        animation.tick();
        currentFrame = animation.getCurrentFrame();
    }

    public Explosion getExplosion()
    {
        return explosion;
    }

    public void setRange(int range)
    {
        this.range = range > 0 ? range : 1;
    }

    public void setCreatedTime()
    {
        createdTime = System.currentTimeMillis();
    }
}
