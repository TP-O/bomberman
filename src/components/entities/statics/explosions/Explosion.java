package components.entities.statics.explosions;

import components.behaviors.animate.Animation;
import components.behaviors.attack.AttackBehavior;
import components.behaviors.attack.MonsterCollisionAttack;
import components.entities.statics.StaticEntity;

public abstract class Explosion extends StaticEntity implements Cloneable
{
    protected AttackBehavior attack;

    public Explosion()
    {
        super();

        margin = 0;
        padding = 0;
    }

    @Override
    protected void initializeActions()
    {
        // Set animation
        animation = new Animation(50, frames);

        // Set attack type
        attack = new MonsterCollisionAttack(this);
    }

    @Override
    public Object clone()
    {
        // Reset animation 
        animation.setIndex(0);
        
        try {
            Explosion e = (Explosion) super.clone();
            
            e.setAttack(new MonsterCollisionAttack(e));

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
            // Update frame
            animation.tick();
            currentFrame = animation.getCurrentFrame();

            // Attack
            attack.attack();
        }
    }

    public void setAttack(AttackBehavior attackBehavior)
    {
        attack = attackBehavior;
    }
}
