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
        return collision.isStrict();
    }

    @Override
    public Entity getEntity() {
        return collision.getEntity();
    }

    @Override
    public Entity getCollidedEntity() {
        return collision.getCollidedEntity();
    }

    @Override
    public List<Entity> getCollidedEntities() {
        return collision.getCollidedEntities();
    }

    @Override
    public void useStrictMode() {
        collision.useStrictMode();
    }

    @Override
    public void setEntity(Entity entity) {
        collision.setEntity(entity);
    }

    @Override
    public void setCollidedEntity(Entity collidedEntity) {
        collision.setCollidedEntity(collidedEntity);
    }

    @Override
    public void clearCollidedEntities() {
        collision.clearCollidedEntities();
    }
}
