package components.actions.collide;

import java.util.ArrayList;
import java.util.List;

import components.entities.Entity;

public class CollisionAction implements Collision {

    protected boolean strict;

    protected Entity entity;

    protected Entity collidedEntity;

    protected List<Entity> collidedEntities;

    public CollisionAction() {
        this.collidedEntities = new ArrayList<Entity>();
    }

    public CollisionAction(Entity entity) {
        this.entity = entity;
        this.collidedEntities = new ArrayList<Entity>();
    }

    @Override
    public boolean isStrict() {
        return strict;
    }

    public Entity getEntity() {
        return entity;
    }

    public Entity getCollidedEntity() {
        return collidedEntity;
    }

    public List<Entity> getCollidedEntities() {
        return collidedEntities;
    }

    public void useStrictMode() {
        strict = true;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setCollidedEntity(Entity collidedEntity) {
        this.collidedEntity = collidedEntity;
    }

    public void clearCollidedEntities() {
        collidedEntities.clear();
    }

    @Override
    public boolean isCollided() {
        return false;
    }

    @Override
    public boolean isCollidedTop() {
        return false;
    }

    @Override
    public boolean isCollidedBottom() {
        return false;
    }

    @Override
    public boolean isCollidedLeft() {
        return false;
    }

    @Override
    public boolean isCollidedRight() {
        return false;
    }
}
