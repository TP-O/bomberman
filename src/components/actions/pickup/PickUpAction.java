package components.actions.pickup;

import components.entities.Entity;

public class PickUpAction implements PickUp {

    private Entity entity;

    public PickUpAction(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void pickUp() {
        //
    }
}
