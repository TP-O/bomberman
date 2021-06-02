package components.actions.pickup;

import components.entities.Entity;

public abstract class PickUpDecorator implements PickUp {

    private PickUp pickUp;

    public PickUpDecorator(PickUp pickUp) {
        this.pickUp = pickUp;
    }

    @Override
    public Entity getEntity() {
        return this.pickUp.getEntity();
    }

    @Override
    public void pickUp() {
        this.pickUp.pickUp();
        this.decorate();
    }

    protected abstract void decorate();
}
