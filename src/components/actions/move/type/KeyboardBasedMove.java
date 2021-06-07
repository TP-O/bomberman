package components.actions.move.type;

import components.actions.move.Move;
import components.actions.move.MoveDecorator;
import core.Handler;

public class KeyboardBasedMove extends MoveDecorator {

    private Handler handler;

    public KeyboardBasedMove(Move move) {
        super(move);

        this.handler = Handler.getInstance();
    }

    @Override
    protected void decorate() {
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
