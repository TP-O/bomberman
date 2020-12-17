package components.actions.attack;

import java.util.List;

import components.actions.collide.Collision;
import components.actions.collide.EntityCollision;
import components.entities.Entity;

public class CollisionAttack extends Attack
{
    private Collision collision;

    public CollisionAttack(Entity attacker, List<? extends Entity> victims)
    {
        super(attacker, victims);

        collision = new EntityCollision(attacker, null);
    }

    public void attack()
    {
        victims.forEach(victim -> {
            collision.setTarget(victim);

            if (collision.collideTop()
                    || collision.collideBottom()
                    || collision.collideLeft()
                    || collision.collideRight()
            ) {
                long now = System.currentTimeMillis();

                if (now - attackedTime >= 1000) {
                    victim.setHealth(victim.getHealth() - attacker.getDamage());
                    attackedTime = now;
                }
            }
            
        });
    }
}
