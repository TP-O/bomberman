package components.actions.attack.nonstop;

import app.cache.EntityCache;
import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.collisions.Collision;
import components.collisions.EntityCollision;

public class PlayerAttack extends AttackDecorator
{
    private Collision collision;

    public PlayerAttack(Attack attack)
    {
        super(attack);

        collision = new EntityCollision(attack.getAttacker(), null);
    }

    @Override
    public void decorate()
    {
        EntityCache.get("player").forEach(target -> {
            collision.setTarget(target);

            if (collision.collied()) {
                target.setHealth(target.getHealth() - getAttacker().getDamage());
            }
        });
    }
}
