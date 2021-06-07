package components.actions.attack.controlled;

import components.actions.attack.Attack;
import components.actions.attack.nonstop.BombPlacing;
import components.entities.statics.bombs.Bomb;
import core.Handler;

public class ControlledBombPlacing extends BombPlacing {

    private Handler handler;

    public ControlledBombPlacing(Attack attack, Bomb bomb) {
        super(attack, bomb);

        handler = Handler.getInstance();
    }

    @Override
    protected void decorate() {
        if (handler.getKeyboard().attack.isPressed()) {
            super.decorate();
        }
    }
}
