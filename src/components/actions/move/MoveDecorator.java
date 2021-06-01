package components.actions.move;

import components.actions.collide.Collision;
import components.entities.dynamics.DynamicEntity;

public abstract class MoveDecorator extends Move
{
    private Move move;

    public MoveDecorator(Move move) {
        super(move.getEntity());

        this.move = move;
    }

    public boolean isCollied() {
        return this.move.isCollied();
    }

    public DynamicEntity getEntity() {
        return this.move.getEntity();
    }

    public Collision getCollision() {
        return this.move.getCollision();
    }

    public void setCollision(Collision collision) {
        this.move.setCollision(collision);
    }

    public void moveUp() {
        this.move.moveUp();
    }

    public void moveDown() {
        this.move.moveDown();
    }

    public void moveLeft() {
        this.move.moveLeft();
    }

    public void moveRight() {
        this.move.moveRight();
    }

    public void stand() {
        this.move.stand();
    }

    @Override
    public void move() {
        this.move.move();
    }
}
