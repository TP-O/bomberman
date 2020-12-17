package components.behaviors.attack;

import app.cache.EntityCache;
import components.entities.Entity;
import components.entities.statics.explosions.Explosion;

public class ExplosionAttack implements AttackBehavior
{
    private int range;

    private Entity attacker;

    private Explosion explosion;

    public ExplosionAttack(Entity attacker, Explosion explosion, int range)
    {
        this.attacker = attacker;
        this.explosion = explosion;
        this.range = range;
    }

    @Override
    public void attack()
    {
        explosion.setX(calculateXOfExplosion(attacker.getX(), attacker.getWidth(), attacker.getWidth() * range));
        explosion.setY(calculateYOfExplosion(attacker.getY(), attacker.getHeight(), attacker.getHeight() * range));
        explosion.setWidth(attacker.getWidth() * range);
        explosion.setHeight(attacker.getHeight() * range);
            
        EntityCache.push("explosion", (Explosion) explosion.clone());
    }

    private float calculateXOfExplosion(float x, int width, int explosionWidth)
    {
        return x - (explosionWidth / 2) + (width / 2);
    }

    private float calculateYOfExplosion(float y, int height, int explosionHeight)
    {
        return y - explosionHeight + height;
    }
}
