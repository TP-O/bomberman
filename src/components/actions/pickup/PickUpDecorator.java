package components.actions.pickup;

import components.entities.Entity;

public abstract class PickUpDecorator implements PickUp {

    private PickUp pickUp;

    public PickUpDecorator(PickUp pickUp) {
        this.pickUp = pickUp;
    }

    @Override
    public Entity getEntity() {
        return pickUp.getEntity();
    }

    @Override
    public void pickUp() {
        pickUp.pickUp();
        decorate();
    }

    protected abstract void decorate();
}
