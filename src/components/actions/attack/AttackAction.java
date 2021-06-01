package components.actions.attack;

import components.entities.Entity;

public class AttackAction implements Attack {
    private Entity attacker;

    public AttackAction(Entity attacker) {
        this.attacker = attacker;
    }

    public AttackAction() {
        //
    }

    @Override
    public Entity getAttacker() {
        return attacker;
    }

    @Override
    public void setAttacker(Entity attacker) {
        this.attacker = attacker;
    }

    @Override
    public void attack() {
        //
    }
}
