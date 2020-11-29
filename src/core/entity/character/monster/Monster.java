package core.entity.character.monster;

import java.util.Random;

import app.controller.GameController;
import core.entity.character.Character;

public abstract class Monster extends Character
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

    public Monster(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(gameController, x, y, width, height, health, damage, speed);
        moveIndex = random.nextInt(Direction.values().length);
    }

    private void moveRandomly(boolean reset)
    {
        if (reset) {
            moveIndex = random.nextInt(Direction.values().length);
        }

        switch (Direction.values()[moveIndex]) {
            case UP:
                moveUp(1);
                break;
            case DOWN:
                moveDown(1);
                break;
            case LEFT:
                moveLeft(1);
                break;
            case RIGHT:
                moveRight(1);
                break;
            default:
                break;
        }
    }

    public void tick()
    {
        super.tick();
        
        if (collied) {
            moveRandomly(true);
        }
        else {
            moveRandomly(false);
        }
    }
}
