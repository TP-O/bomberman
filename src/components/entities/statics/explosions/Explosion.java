package components.entities.statics.explosions;

import components.actions.attack.Attack;
import components.actions.attack.AttackAction;
import components.actions.attack.nonstop.BlockAttack;
import components.actions.attack.nonstop.MonsterAttack;
import components.actions.attack.nonstop.PlayerAttack;
import components.animations.StaticAnimation;
import components.entities.statics.StaticEntity;

public abstract class Explosion extends StaticEntity implements Cloneable {

    protected Attack attack;

    protected String[] targets = {};

    @Override
    protected void setEntityParameters() {
        margin = 0;
        padding = 0;
    }

    @Override
    protected void initializeActions() {
        //
    }

    @Override
    public Object clone() {
        try {
            Explosion e = (Explosion) super.clone();

            return setClone(e);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void tick() {
        // The explosion will be deleted if all of images are rendered
        if (animation.getIndex() == frames.size() - 1) {
            delete();
        } else {
            super.tick();

            // Attack
            attack.attack();
        }
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public void setAnimation(StaticAnimation animation) {
        this.animation = animation;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    protected Explosion setClone(Explosion explosion) {
        Attack attack = new AttackAction(explosion);

        for (int i = 0; i < targets.length; i++) {
            if (targets[i] == "Block") {
                attack = new BlockAttack(attack);
            } else if (targets[i] == "Monster") {
                attack = new MonsterAttack(attack);
            } else if (targets[i] == "Player") {
                attack = new PlayerAttack(attack);
            }
        }

        explosion.setAttack(attack);
        explosion.setAnimation(new StaticAnimation(explosion, 50));

        return explosion;
    }
}
