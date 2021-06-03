package components.entities.statics.traps;

import components.actions.attack.Attack;
import components.actions.attack.AttackAction;
import components.entities.statics.StaticEntity;
import config.TileConfig;

public abstract class Trap extends StaticEntity {

    protected Attack attack;

    public Trap(float x, float y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected void setEntityParameters() {
        margin = 0;
        padding = 0;
        width = TileConfig.WIDTH;
        height = TileConfig.HEIGHT;
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        attack = new AttackAction(this);
    }
}
