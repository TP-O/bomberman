package components.actions.pickup;

import app.cache.ItemCache;
import components.actions.collide.Collision;
import components.actions.collide.EntityCollision;
import components.entities.Entity;
import components.entities.dynamic.character.player.Player;

public class ItemPickUp extends Pickup
{
    private ItemCache cache;

    private Collision collision;

    private Entity entity;

    public ItemPickUp(Entity entity)
    {   
        this.entity = entity;

        cache = new ItemCache();
    }

    @Override
    public void pick()
    {
        cache.get().forEach(item -> {
            collision = new EntityCollision(entity, item);

            if (collision.collideTop()
                    || collision.collideBottom()
                    || collision.collideLeft()
                    || collision.collideRight()
            ) {
                item.boost((Player) entity);
            }
        });
    }        
}
