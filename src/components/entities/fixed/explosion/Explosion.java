package components.entities.fixed.explosion;

import components.actions.animate.Animation;
import components.entities.constract.Attackable;
import components.entities.fixed.FixedEntity;

import java.awt.Graphics;

import components.actions.attack.Attack;
import components.actions.attack.CollisionAttack;
import app.cache.MonsterCache;
import core.Handler;

public abstract class Explosion extends FixedEntity implements Attackable, Cloneable
{
    protected int damage;

    protected Attack attack;

    public Explosion(Handler handler)
    {
        super(handler);

        setEntityParameters();

        loadAllFrames();
        initializeAnimation();

        attack = new CollisionAttack(this, (new MonsterCache()).get());
    }

    @Override
    public int getDamage()
    {
        return damage;
    }

    @Override
    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    @Override
    protected void initializeAnimation()
    {
        animation = new Animation(50, frames);
    }

    @Override
    public void attack()
    {
        attack.attack();
    }

    @Override
    public Object clone()
    { 
        animation.setIndex(0);
        
        try {
            Explosion e = (Explosion) super.clone();

            attack = new CollisionAttack(e, (new MonsterCache()).get());

            return e;
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void tick()
    {
        // The explosion will be deleted if all of images are rendered
        if (animation.getIndex() == frames.size() - 1) {
            deleted = true;
        }
        else {
            animation.tick();
            currentFrame = animation.getCurrentFrame();
            
            attack();
        }
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
