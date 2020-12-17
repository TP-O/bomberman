package components.behaviors.attack;

import app.cache.EntityCache;
import components.entities.Entity;

public class MonsterCollisionAttack extends CollisionAttack
{
    public MonsterCollisionAttack(Entity attacker)
    {
        super(attacker, EntityCache.get("monster"));
    }
}
