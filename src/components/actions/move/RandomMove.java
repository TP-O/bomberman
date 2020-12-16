package components.actions.move;

import java.util.Random;

import components.entities.Entity;
import core.Handler;

public class RandomMove extends Move
{
    private enum Direction
    {
        UP,
        DOWN,
        LEFT,
        RIGHT,
    }

    private int moveIndex;

    private Random random = new Random();

    public RandomMove(Handler handler, Entity entity, float speed)
    {
        super(handler.getMap(), entity, speed);

        moveIndex = random.nextInt(Direction.values().length);
    }

    @Override
    public void move()
    {
        if (collied) {
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
