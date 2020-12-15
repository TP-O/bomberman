package components.actions.move;

import components.entities.Entity;
import core.Handler;

public class KeyboardBasedMove extends Move
{
    private Handler handler;

    public KeyboardBasedMove(Handler handler, Entity entity, float speed)
    {
        super(handler.getMap(), entity, speed);

        this.handler = handler;
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
