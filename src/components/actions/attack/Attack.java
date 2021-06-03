package components.actions.attack;

import components.entities.Entity;

public interface Attack {
    public Entity getAttacker();

    public void setAttacker(Entity attacker);

    public void attack();
}
