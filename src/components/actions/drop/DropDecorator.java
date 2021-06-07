package components.actions.drop;

import components.entities.Entity;

public abstract class DropDecorator implements Drop {

    private Drop drop;

    public DropDecorator(Drop drop) {
        this.drop = drop;
    }

    @Override
    public Entity getEntity() {
        return drop.getEntity();
    }

    @Override
    public void drop() {
        drop.drop();
        decorate();
    }

    protected abstract void decorate();
}
