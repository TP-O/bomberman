package components.actions.attack.controlled;

import components.actions.attack.Attack;
import components.actions.attack.nonstop.PlayerAttack;
import core.Handler;

public class ControlledPlayerAttack extends PlayerAttack
{
    private Handler handler;

    public ControlledPlayerAttack(Attack attack)
    {
        super(attack);

        handler = Handler.getInstance();
    }

    @Override
    public void decorate()
    {
        if (handler.getKeyboard().attack.isPressed()) {
            super.decorate();
        }
    }
}
