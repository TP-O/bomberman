package components.actions.pickup.controlled;

import components.actions.pickup.PickUp;
import components.actions.pickup.nonstop.ItemPickUp;
import core.Handler;

public class ControlledItemPickUp extends ItemPickUp {

    private Handler handler;

    public ControlledItemPickUp(PickUp pickUp) {
        super(pickUp);

        this.handler = Handler.getInstance();
    }

    @Override
    protected void decorate() {
        if (handler.getKeyboard().attack.isPressed()) {
            super.decorate();
        }
    }
}
