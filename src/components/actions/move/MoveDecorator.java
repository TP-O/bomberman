package components.actions.move;

import components.actions.collide.Collision;
import components.entities.dynamics.DynamicEntity;

public abstract class MoveDecorator extends Move {

    private Move move;

    public MoveDecorator(Move move) {
        super(move.getEntity());

        this.move = move;
    }

    public boolean isCollied() {
        return move.isCollied();
    }

    public DynamicEntity getEntity() {
        return move.getEntity();
    }

    public Collision getCollision() {
        return move.getCollision();
    }

    public void setCollision(Collision collision) {
        move.setCollision(collision);
    }

    public void moveUp() {
        move.moveUp();
    }

    public void moveDown() {
        move.moveDown();
    }

    public void moveLeft() {
        move.moveLeft();
    }

    public void moveRight() {
        move.moveRight();
    }

    public void stand() {
        move.stand();
    }

    @Override
    public void move() {
        move.move();
        decorate();
    }

    protected abstract void decorate();
}
