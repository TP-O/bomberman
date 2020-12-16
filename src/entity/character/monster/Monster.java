package entity.character.monster;

import java.util.Random;
import java.util.ArrayList;
import app.event.event.KilledMonsterEvent;
import app.model.ExplosionModel;
import core.main.Handler;
import entity.character.Character;
import entity.item.Item;
import entity.item.children.*;
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

    private boolean deleted;

    Item item;

    ArrayList<Item> items = new ArrayList<Item>();

    private static Random random = new Random();

    boolean chance50oftrue = (random.nextInt(2) == 0) ? true : false;

    public boolean isDeleted()
    {
        return deleted;
    }

    public Monster(Handler handler, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(handler, x, y, width, height, health, damage, speed);

        moveIndex = random.nextInt(Direction.values().length);
        deleted = false;      

        // Add 5 items to the list
        items.add(0, new SpeedBoost(handler));
        items.add(1, new DamageBoost(handler));
        items.add(2, new Healing(handler));
        items.add(3, new MaxHP(handler));
        items.add(4, new BombBoost(handler));

        // Set item randomly
        item = items.get(random.nextInt(5));
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
                    health -= explosion.getDamage();
                    attackedTime = now;

                    if (health <= 0 && chance50oftrue == true){
                        deleted = true;
                        Helper.event(new KilledMonsterEvent(item, x + width/2, y + height/2));
                        
                    }else{
                        deleted = true;
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
