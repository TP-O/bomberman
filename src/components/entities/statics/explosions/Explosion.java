package components.entities.statics.explosions;

import components.actions.attack.Attack;
import components.actions.attack.AttackAction;
import components.actions.attack.nonstop.MonsterAttack;
import components.actions.attack.nonstop.PlayerAttack;
import components.animation.StaticAnimation;
import components.entities.statics.StaticEntity;

public abstract class Explosion extends StaticEntity implements Cloneable
{
    private Attack attack;

    public Explosion()
    {
        super();

        margin = 0;
        padding = 0;
    }

    @Override
    protected void initializeActions()
    {
        //
    }

    @Override
    public Object clone()
    {
        try {
            Explosion e = (Explosion) super.clone();

            return setClone(e);
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
            delete();
        }
        else {
            super.tick();

            // Attack
            attack.attack();
        }
    }

    public void setAttack(Attack attack)
    {
        this.attack = attack;
    }

    public void setAnimation(StaticAnimation animation)
    {
        this.animation = animation;
    }

    protected Explosion setClone(Explosion explosion)
    {
        explosion.setAnimation(new StaticAnimation(explosion, 50));
        explosion.setAttack(new PlayerAttack(new MonsterAttack(new AttackAction(explosion))));

        return explosion;
    }
}
