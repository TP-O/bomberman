package components.actions.attack.nonstop;

import app.cache.EntityCache;
import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.entities.statics.bombs.Bomb;

public class BombPlacing extends AttackDecorator {

    private Bomb bomb;

    private long createdAt = 0;

    public BombPlacing(Attack attack, Bomb bomb) {
        super(attack);

        this.bomb = bomb;
    }

    @Override
    protected void decorate() {
        long now = System.currentTimeMillis();

        float x = getAttacker().getX() + getAttacker().getWidth() / 4;
        float y = getAttacker().getY() + getAttacker().getHeight() / 2;

        if (now - createdAt > 500) {
            bomb.setX(x);
            bomb.setY(y);
            bomb.setCreatedTime();

            EntityCache.push("bomb", (Bomb) bomb.clone());

            createdAt = now;
        }
    }
}
