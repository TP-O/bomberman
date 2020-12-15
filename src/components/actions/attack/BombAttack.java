package components.actions.attack;

import java.util.List;

import app.events.BombPlacingEvent;
import components.entities.Entity;
import components.entities.dynamic.character.player.Player;
import helper.Helper;

public class BombAttack extends Attack {

    public BombAttack(Entity attacker, List<? extends Entity> victims)
    {
        super(attacker, victims);
    }

    @Override
    public void attack()
    {
        Helper.event(new BombPlacingEvent(((Player) attacker).getBomb(),
                attacker.getX() + attacker.getWidth() / 4, attacker.getY() + attacker.getHeight() / 2));
    }
}
