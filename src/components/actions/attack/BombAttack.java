package components.actions.attack;

import app.events.BombPlacingEvent;
import components.entities.Entity;
import components.entities.dynamic.character.player.Player;
import helper.Helper;

public class BombAttack extends Attack {

    public BombAttack(Entity attacker)
    {
        super(attacker, null);
    }

    @Override
    public void attack()
    {
        Helper.event(new BombPlacingEvent(((Player) attacker).getBomb(),
                attacker.getX() + attacker.getWidth() / 4, attacker.getY() + attacker.getHeight() / 2));
    }
}
