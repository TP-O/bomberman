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
    public void move() {
        super.move();

        if (this.handler.getKeyboard().up.isPressed()) {
            this.moveUp();
        }
        else if (this.handler.getKeyboard().down.isPressed()) {
            this.moveDown();
        }
        else if (this.handler.getKeyboard().left.isPressed()) {
            this.moveLeft();
        }
        else if (this.handler.getKeyboard().right.isPressed()) {
            this.moveRight();
        }
        else {
            this.stand();
        }
    }
}
