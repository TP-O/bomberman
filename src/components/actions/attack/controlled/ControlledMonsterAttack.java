package components.actions.attack.controlled;

import components.actions.attack.Attack;
import components.actions.attack.nonstop.MonsterAttack;
import core.Handler;

public class ControlledMonsterAttack extends MonsterAttack
{
    private Handler handler;

    public ControlledMonsterAttack(Attack attack)
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
