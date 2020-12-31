package components.actions.attack.nonstop;

import app.cache.EntityCache;
import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.collision.Collision;
import components.collision.EntityCollision;

public class MonsterAttack extends AttackDecorator
{
    private Collision collision;

    public MonsterAttack(Attack attack)
    {
        super(attack);

        collision = new EntityCollision(attack.getAttacker(), null);
    }

    @Override
    public void decorate()
    {
        EntityCache.get("monster").forEach(target -> {
            collision.setTarget(target);

            if (collision.collied()) {
                target.setHealth(target.getHealth() - getAttacker().getDamage());
            }
        });
    }
}
