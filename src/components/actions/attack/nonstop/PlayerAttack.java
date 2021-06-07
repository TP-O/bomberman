package components.actions.attack.nonstop;

import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.actions.collide.entity.PlayerCollision;

public class PlayerAttack extends AttackDecorator {

    private Collision collision;

    public PlayerAttack(Attack attack) {
        super(attack);

        collision = new CollisionAction(attack.getAttacker());
        collision = new PlayerCollision(collision);
    }

    @Override
    protected void decorate() {
        if (collision.isCollided()) {
            collision.getCollidedEntities().forEach(target -> {
                target.setHealth(target.getHealth() - getAttacker().getDamage());
            });

            collision.clearCollidedEntities();
        }
    }
}
