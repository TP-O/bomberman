package components.actions.drop;

import components.entities.Entity;

public class DropAcction implements Drop {

    private Entity entity;

    public DropAcction(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void drop() {
        //
    }
}
