package components.actions.attack;

import components.entities.Entity;

public abstract class AttackDecorator implements Attack {

    private Attack attack;

    public AttackDecorator(Attack attack) {
        this.attack = attack;
    }

    @Override
    public Entity getAttacker() {
        return this.attack.getAttacker();
    }

    @Override
    public void setAttacker(Entity attacker) {
        this.attack.setAttacker(attacker);
    }

    @Override
    public void attack() {
        this.attack.attack();
        this.decorate();
    }

    protected abstract void decorate();
}
