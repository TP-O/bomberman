package components.entities.statics.bombs;

import components.actions.attack.Attack;
import components.animations.StaticAnimation;
import components.entities.statics.StaticEntity;
import components.entities.statics.explosions.Explosion;
import components.entities.statics.explosions.children.ExplosionA;
import config.TileConfig;

public abstract class Bomb extends StaticEntity implements Cloneable {

    protected int range;

    protected int timer;

    protected Attack attack;

    protected long createdTime;

    protected Explosion explosion;

    @Override
    protected void setEntityParameters() {
        range = 2;
        timer = 2000;
        width = TileConfig.WIDTH / 2;
        height = TileConfig.HEIGHT / 2;

        explosion = new ExplosionA();
    }

    @Override
    public Object clone() {
        try {
            Bomb b = (Bomb) super.clone();

            return setClone(b);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void tick() {
        long now = System.currentTimeMillis();

        // The bomb will be deleted if the time is up
        if (now - createdTime >= timer) {
            // Attackkkk
            attack.attack();

            // Delete bomb
            delete();
        } else {
            super.tick();
        }
    }

    public Explosion getExplosion() {
        return explosion;
    }

    public void setRange(int range) {
        this.range = range > 0 ? range : 1;
    }

    public void setCreatedTime() {
        createdTime = System.currentTimeMillis();
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public void setAnimation(StaticAnimation animation) {
        this.animation = animation;
    }

    protected abstract Bomb setClone(Bomb bomb);
}
