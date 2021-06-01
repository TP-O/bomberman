package components.actions.move.type;

import java.util.Random;

import components.actions.move.Move;
import components.actions.move.MoveDecorator;

public class RandomMove extends MoveDecorator {

    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
    }

    private int moveIndex;

    private static Random random = new Random();

    public RandomMove(Move move) {
        super(move);

        moveIndex = random.nextInt(Direction.values().length);
    }

    @Override
    public void move() {
        super.move();

        if (this.isCollied()) {
            moveIndex = random.nextInt(Direction.values().length);
        }

        switch (Direction.values()[moveIndex]) {
            case UP:
                moveUp();
                break;

            case DOWN:
                moveDown();
                break;

            case LEFT:
                moveLeft();
                break;

            case RIGHT:
                moveRight();
                break;

            default:
                break;
        }
    }
}
