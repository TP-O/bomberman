package components.actions.attack;

import components.entities.Entity;

public abstract class AttackDecorator implements Attack {
    private Attack attack;

    public AttackDecorator(Attack attack) {
        this.attack = attack;
    }

    @Override
    public Entity getAttacker() {
        return attack.getAttacker();
    }

    @Override
    public void setAttacker(Entity attacker) {
        attack.setAttacker(attacker);
    }

    @Override
    public void attack() {
        attack.attack();
        decorate();
    }

    protected abstract void decorate();
}
