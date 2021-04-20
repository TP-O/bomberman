package components.actions.pickup.nonstop;

import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.actions.collide.entity.ItemCollision;
import components.actions.pickup.PickUp;
import components.actions.pickup.PickUpDecorator;
import components.entities.dynamics.characters.player.Player;
import components.entities.statics.items.Item;

public class ItemPickUp extends PickUpDecorator
{
    private Collision collision;

    public ItemPickUp(PickUp pickUp)
    {
        super(pickUp);

        collision = new CollisionAction(pickUp.getEntity());
        collision = new ItemCollision(collision);
    }

    @Override
    public void decorate()
    {
        if (collision.isCollided()) {
            collision.getCollidedEntities().forEach(item -> {
                ((Item) item).boost((Player) getEntity());
            });

            collision.clearCollidedEntities();
        }
    }
}
