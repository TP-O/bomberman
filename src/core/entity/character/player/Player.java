package core.entity.character.player;

import core.entity.character.Character;
import helper.Helper;
import app.controller.CharacterController;
import app.controller.GameController;

public abstract class Player extends Character
{
    public Player(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(gameController , x, y, width, height, health, damage, speed);
    }

    private void detectAttack()
    {
        CharacterController.getMonsters().forEach(monster -> {
            boolean upperLeftCornerCollied = Helper.inSquare(x + padding, y + padding, monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
            boolean lowerLeftCornerCollied = Helper.inSquare(x + padding, y + height - padding, monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
            boolean upperRightCornerCollied = Helper.inSquare(x + width - padding, y + padding, monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());
            boolean lowerRightCornerCollied = Helper.inSquare(x + width - padding, y + height - padding, monster.getX(), monster.getY(), monster.getWidth(), monster.getHeight());

            if (upperLeftCornerCollied || lowerLeftCornerCollied || upperRightCornerCollied || lowerRightCornerCollied) {
                health -= monster.getDamage();
                System.out.print("Is attacked");    
            }
        });
    }
    
    public void tick()
    {
        super.tick();

        detectAttack();

        if (gameController.getKeyService().up.isPressed()) {
            moveUp(speed);
        }

        if (gameController.getKeyService().down.isPressed()) {
            moveDown(speed);
        }

        if (gameController.getKeyService().left.isPressed()) {
            moveLeft(speed);
        }
        
        if (gameController.getKeyService().right.isPressed()) {
            moveRight(speed);
        }
    }
}
