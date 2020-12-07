package entity.character.player;

import entity.bomb.*;
import entity.bomb.children.*;
import entity.character.Character;

import app.controller.GameController;
import app.event.event.BombPlacingEvent;
import helper.Helper;
import core.main.Handler;

public abstract class Player extends Character
{
    Bomb bomb;

    public Player(Handler handler, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(handler , x, y, width, height, health, damage, speed);

        // Set default bomb of the player
        bomb = new BombB(handler);
    }

    public void detectAttack()
    {
        GameController.currentMonsters.forEach(monster -> {
            boolean upperLeftCornerCollied = Helper.inSquare(x + padding, y + padding,
                    monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
            boolean lowerLeftCornerCollied = Helper.inSquare(x + padding, y + height - padding,
                    monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
            boolean upperRightCornerCollied = Helper.inSquare(x + width - padding, y + padding,
                    monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
            boolean lowerRightCornerCollied = Helper.inSquare(x + width - padding, y + height - padding,
                    monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());

            if (upperLeftCornerCollied
                    || lowerLeftCornerCollied
                    || upperRightCornerCollied
                    || lowerRightCornerCollied
            ) {
                long now = System.currentTimeMillis();

                if (now - attackedTime >= 1000) {
                    health -= monster.getDamage();
                    attackedTime = now;
                }
            }
        });
    }
    
    @Override
    public void tick()
    {
        super.tick();

        detectAttack();

        if (handler.getKeyBoard().up.isPressed()) {
            moveUp(speed);
        }

        if (handler.getKeyBoard().down.isPressed()) {
            moveDown(speed);
        }

        if (handler.getKeyBoard().left.isPressed()) {
            moveLeft(speed);
        }
        
        if (handler.getKeyBoard().right.isPressed()) {
            moveRight(speed);
        }

        if (handler.getKeyBoard().attack.isPressed()) {
            Helper.event(new BombPlacingEvent(bomb, x + width/4, y + height/2));
        }
    }
}