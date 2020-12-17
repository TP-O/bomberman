package components.actions.attack;

import java.util.List;

import components.entities.Entity;

public abstract class Attack
{
    protected Entity attacker;

    protected List<? extends Entity> victims;

    protected long attackedTime = 0;

    public Attack(Entity attacker, List<? extends Entity> victims)
    {
        this.attacker = attacker;
        this.victims = victims;
    }

    public abstract void attack();
}
