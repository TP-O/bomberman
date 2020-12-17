package components.behaviors.attack;

import app.cache.EntityCache;
import components.entities.Entity;

public class PlayerCollisionAttack extends CollisionAttack
{
    public PlayerCollisionAttack(Entity attacker)
    {
        super(attacker, EntityCache.get("player"));
    }
}
