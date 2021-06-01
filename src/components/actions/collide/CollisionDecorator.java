package components.actions.collide;

import java.util.List;

import components.entities.Entity;

public abstract class CollisionDecorator implements Collision {

    protected Collision collision;

    public CollisionDecorator(Collision collision) {
        this.collision = collision;
    }

    @Override
    public boolean isStrict() {
        return this.collision.isStrict();
    }

    @Override
    public Entity getEntity() {
        return this.collision.getEntity();
    }

    @Override
    public Entity getCollidedEntity() {
        return this.collision.getCollidedEntity();
    }

    @Override
    public List<Entity> getCollidedEntities() {
        return this.collision.getCollidedEntities();
    }

    @Override
    public void useStrictMode() {
        this.collision.useStrictMode();
    }

    @Override
    public void setEntity(Entity entity) {
        this.collision.setEntity(entity);
    }

    @Override
    public void setCollidedEntity(Entity collidedEntity) {
        this.collision.setCollidedEntity(collidedEntity);
    }

    @Override
    public void clearCollidedEntities() {
        this.collision.clearCollidedEntities();
    }
}
