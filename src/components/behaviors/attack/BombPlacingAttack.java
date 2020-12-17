package components.behaviors.attack;

import app.cache.EntityCache;
import components.entities.Entity;
import components.entities.statics.bombs.Bomb;

public class BombPlacingAttack implements AttackBehavior
{
    private Bomb bomb;

    private Entity attacker;

    public BombPlacingAttack(Entity attacker,  Bomb bomb)
    {
        this.bomb = bomb;
        this.attacker = attacker;
    }

    @Override
    public void attack()
    {
        bomb.setX(attacker.getX() + attacker.getWidth() / 4);
        bomb.setY(attacker.getY() + attacker.getHeight() / 2);
        bomb.setCreatedTime();

        try {
            EntityCache.push("bomb", (Bomb) bomb.clone());

        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
