package entity.character.monster;

import java.util.Random;

import app.model.ExplosionModel;
import config.MonsterConfig;
import core.main.Handler;
import entity.character.Character;
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

    protected int damage;

    private int moveIndex;

    private boolean deleted;

    private static Random random = new Random();

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public Monster(Handler handler, float x, float y)
    {
        super(handler);

        this.x = x;
        this.y = y;

        deleted = false;
        moveIndex = random.nextInt(Direction.values().length);
    }

    @Override
    protected void loadInfo()
    {
        width = MonsterConfig.WIDTH;
        height = MonsterConfig.HEIGHT;
        health = MonsterConfig.HEALTH;
        speed = MonsterConfig.SPEED;
        damage = MonsterConfig.DAMAGE;
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

    public void detectAttack()
    {
        ExplosionModel.all().forEach(explosion -> {
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
                    System.out.println("AAAA NONO");
                    attackedTime = now;
                    health -= explosion.getDamage();

                    if (health <= 0) {
                        deleted = true;
                    }
                }
            }
        });
    }
}
