package components.entities.statics.bombs.children;

import asset.Asset;
import components.actions.attack.AttackAction;
import components.actions.attack.nonstop.ExplosionCreation;
import components.animations.StaticAnimation;
import components.entities.statics.bombs.Bomb;

public class BombA extends Bomb {

    @Override
    protected void initializeActions() {
        //
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        frames.add(Asset.get("bomb01").crop(8, 11, 207, 196));
        frames.add(Asset.get("bomb01").crop(218, 7, 207, 196));
        frames.add(Asset.get("bomb01").crop(447, 7, 207, 196));
        frames.add(Asset.get("bomb01").crop(647, 7, 207, 196));
        frames.add(Asset.get("bomb01").crop(852, 7, 207, 196));
        frames.add(Asset.get("bomb01").crop(1054, 7, 207, 196));
    }

    @Override
    protected Bomb setClone(Bomb bomb) {
        bomb.setAnimation(new StaticAnimation(bomb, 200));
        bomb.setAttack(new ExplosionCreation(new AttackAction(bomb), explosion, range));

        return bomb;
    }
}
