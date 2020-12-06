package core.entity.character.monster;

import java.util.Random;

import app.controller.CharacterController;
import app.controller.ExplosionController;
import app.controller.GameController;
import core.entity.character.Character;
import helper.Helper;

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

    private ExplosionController explosion;

    private static Random random = new Random();

    public Monster(GameController game, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(game, x, y, width, height, health, damage, speed);

        moveIndex = random.nextInt(Direction.values().length);

        // Explosion manager
        explosion = new ExplosionController();
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

    @Override
    public void detectAttack()
    {
        explosion.getExplosions().forEach(explosion -> {
            boolean upperLeftCornerCollied = Helper.inSquare(x + padding, y + padding,
                    explosion.getX(), explosion.getY(), explosion.getWidth(), explosion.getHeight());
            boolean lowerLeftCornerCollied = Helper.inSquare(x + padding, y + height - padding,
                    explosion.getX(), explosion.getY(), explosion.getWidth(), explosion.getHeight());
            boolean upperRightCornerCollied = Helper.inSquare(x + width - padding, y + padding,
                    explosion.getX(), explosion.getY(), explosion.getWidth(), explosion.getHeight());
            boolean lowerRightCornerCollied = Helper.inSquare(x + width - padding, y + height - padding,
                    explosion.getX(), explosion.getY(), explosion.getWidth(), explosion.getHeight());

            if (upperLeftCornerCollied
                    || lowerLeftCornerCollied
                    || upperRightCornerCollied
                    || lowerRightCornerCollied
            ) {
                long now = System.currentTimeMillis();

                if (now - attackedTime >= 1000) {
                    health -= explosion.getDamage();
                    attackedTime = now;

                    if (health <= 0) {
                        CharacterController.trash.add(this);
                    }
                }
            }
        });
    }

    @Override
    public void tick()
    {
        super.tick();

        detectAttack();
        
        if (collied) {
            moveRandomly(true);
        }
        else {
            moveRandomly(false);
        }
    }
}
