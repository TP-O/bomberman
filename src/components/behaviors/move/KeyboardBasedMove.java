package components.behaviors.move;

import components.entities.dynamics.DynamicEntity;
import core.Handler;

public class KeyboardBasedMove extends Move
{
    private Handler handler;

    public KeyboardBasedMove(DynamicEntity entity)
    {
        super(entity);

        handler = Handler.getInstance();
    }

    @Override
    public void move()
    {
        if (handler.getKeyboard().up.isPressed()) {
            moveUp();
        }
        else if (handler.getKeyboard().down.isPressed()) {
            moveDown();
        }
        else if (handler.getKeyboard().left.isPressed()) {
            moveLeft();
        }
        else if (handler.getKeyboard().right.isPressed()) {
            moveRight();
        }
        else {
            stand();
        }
    }
}
