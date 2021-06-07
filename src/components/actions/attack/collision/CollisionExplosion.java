package components.actions.attack.collision;

import components.actions.attack.Attack;
import components.actions.attack.nonstop.ExplosionCreation;
import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.actions.collide.entity.PlayerCollision;
import components.entities.statics.explosions.Explosion;

public class CollisionExplosion extends ExplosionCreation {

    protected int timer;

    protected long createdTime;

    private Collision collision;

    public CollisionExplosion(Attack attack, Explosion explosion, int range) {
        super(attack, explosion, range);

        this.timer = 8000;
        this.createdTime = System.currentTimeMillis();
        this.collision = new CollisionAction(attack.getAttacker());
        this.collision = new PlayerCollision(collision);
    }

    @Override
    protected void decorate() {
        long now = System.currentTimeMillis();

        if (collision.isCollided() || now - createdTime >= timer) {
            super.decorate();

            this.getAttacker().delete();
            this.collision.clearCollidedEntities();
        }
    }
}
