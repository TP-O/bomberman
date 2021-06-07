package components.entities.statics.traps.children;

import asset.Asset;
import components.actions.attack.nonstop.PlayerAttack;
import components.entities.statics.traps.Trap;

public class Lava extends Trap {

    public Lava(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        damage = 5;
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        attack = new PlayerAttack(attack);
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("lava").crop(41, 25, 315, 322));
        frames.add(Asset.get("lava").crop(510, 24, 315, 322));
        frames.add(Asset.get("lava").crop(38, 418, 315, 322));
        frames.add(Asset.get("lava").crop(510, 419, 315, 322));
    }

    @Override
    public void tick() {
        super.tick();

        attack.attack();
    }
}
