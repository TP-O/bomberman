package components.actions.attack.nonstop;

import app.cache.EntityCache;
import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.entities.statics.explosions.Explosion;

public class ExplosionCreation extends AttackDecorator {

    private int range;

    private Explosion explosion;

    public ExplosionCreation(Attack attack, Explosion explosion, int range) {
        super(attack);

        this.explosion = explosion;
        this.range = range;
    }

    @Override
    protected void decorate() {
        explosion.setX(calculateXOfExplosion(getAttacker().getX(),
                getAttacker().getWidth(), getAttacker().getWidth() * range));
        explosion.setY(calculateYOfExplosion(getAttacker().getY(),
                getAttacker().getHeight(), getAttacker().getHeight() * range));
        explosion.setWidth(getAttacker().getWidth() * range);
        explosion.setHeight(getAttacker().getHeight() * range);

        EntityCache.push("explosion", (Explosion) explosion.clone());
    }

    private float calculateXOfExplosion(float x, int width, int explosionWidth) {
        return x - (explosionWidth / 2) + (width / 2);
    }

    private float calculateYOfExplosion(float y, int height, int explosionHeight) {
        return y - explosionHeight + height;
    }
}
