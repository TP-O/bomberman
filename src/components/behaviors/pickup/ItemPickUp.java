package components.behaviors.pickup;

import app.cache.EntityCache;
import components.behaviors.collide.CollisionBehavior;
import components.behaviors.collide.EntityCollision;
import components.entities.dynamics.character.player.Player;
import components.entities.statics.items.Item;

public class ItemPickUp implements PickUpBehavior
{
    private Player entity;

    private CollisionBehavior collision;

    public ItemPickUp(Player entity)
    {   
        this.entity = entity;
    }

    @Override
    public void pickUp()
    {
        EntityCache.get("item").forEach(item -> {
            collision = new EntityCollision(entity, item);

            if (collision.collied()) {
                ((Item) item).boost(entity);
            }
        });
    }        
}
