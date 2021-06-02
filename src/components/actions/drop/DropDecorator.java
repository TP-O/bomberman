package components.actions.drop;

import components.entities.Entity;

public abstract class DropDecorator implements Drop {

    private Drop drop;

    public DropDecorator(Drop drop) {
        this.drop = drop;
    }

    @Override
    public Entity getEntity() {
        return this.drop.getEntity();
    }

    @Override
    public void drop() {
        this.drop.drop();
        this.decorate();
    }

    protected abstract void decorate();
}
