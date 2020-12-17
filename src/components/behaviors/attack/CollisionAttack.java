package components.behaviors.attack;

import java.util.List;

import components.behaviors.collide.CollisionBehavior;
import components.behaviors.collide.EntityCollision;
import components.entities.Entity;

public class CollisionAttack implements AttackBehavior
{
    private Entity attacker;

    private CollisionBehavior collision;

    private List<Entity> victims;

    public CollisionAttack(Entity attacker, List<Entity> victims)
    {
        this.attacker = attacker;
        this.victims = victims;

        collision = new EntityCollision(attacker, null);
    }

    public void attack()
    {
        victims.forEach(victim -> {
            collision.setTarget(victim);

            if (collision.collied()) {
                ((Entity) victim).setHealth(((Entity) victim).getHealth() - attacker.getDamage());
            }
            
        });
    }
}
