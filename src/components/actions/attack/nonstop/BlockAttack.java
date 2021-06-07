package components.actions.attack.nonstop;

import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.actions.collide.entity.BlockCollision;

public class BlockAttack extends AttackDecorator {

    private Collision collision;

    public BlockAttack(Attack attack) {
        super(attack);

        collision = new CollisionAction(attack.getAttacker());
        collision = new BlockCollision(collision);
    }

    @Override
    protected void decorate() {
        if (collision.isCollided()) {
            collision.getCollidedEntities().forEach(target -> {
                target.delete();
            });

            collision.clearCollidedEntities();
        }
    }
}
