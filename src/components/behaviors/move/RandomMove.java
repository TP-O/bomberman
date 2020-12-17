package components.behaviors.move;

import java.util.Random;

import components.entities.dynamics.DynamicEntity;

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

    private static Random random = new Random();

    public RandomMove(DynamicEntity entity)
    {
        super(entity);

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
