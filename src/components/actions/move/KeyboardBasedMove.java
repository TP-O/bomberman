package components.actions.move;

import components.entities.Entity;

public class KeyboardBasedMove extends Move
{
    public KeyboardBasedMove(Entity entity, float speed)
    {
        super(entity.getHandler().getMap(), entity, speed);
    }

    @Override
    public void move()
    {
        if (entity.getHandler().getKeyboard().up.isPressed()) {
            moveUp();
        }
        else if (entity.getHandler().getKeyboard().down.isPressed()) {
            moveDown();
        }
        else if (entity.getHandler().getKeyboard().left.isPressed()) {
            moveLeft();
        }
        else if (entity.getHandler().getKeyboard().right.isPressed()) {
            moveRight();
        }
        else {
            stand();
        }
    }
}
