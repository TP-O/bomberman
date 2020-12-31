package components.actions.pickup.nonstop;

import app.cache.EntityCache;
import components.actions.pickup.PickUp;
import components.actions.pickup.PickUpDecorator;
import components.collision.Collision;
import components.collision.EntityCollision;
import components.entities.dynamics.character.player.Player;
import components.entities.statics.items.Item;

public class ItemPickUp extends PickUpDecorator
{
    private Collision collision;

    public ItemPickUp(PickUp pickUp)
    {
        super(pickUp);

        collision = new EntityCollision(getEntity(), null);
    }

    @Override
    public void decorate()
    {
        EntityCache.get("item").forEach(item -> {
            collision.setTarget(item);

            if (collision.collied()) {
                ((Item) item).boost((Player) getEntity());
            }
        });
    }
}
