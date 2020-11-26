package core.entity.character.player;

import core.entity.character.Character;
import app.controller.GameController;

public abstract class Player extends Character
{
    public Player(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(gameController , x, y, width, height, health, damage, speed);
    }
    
    public void tick()
    {
        super.tick();

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
