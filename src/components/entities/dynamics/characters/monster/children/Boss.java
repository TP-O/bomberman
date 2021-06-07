package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.actions.attack.random.RandomBombPlacing;
import components.actions.attack.random.RandomSuicideMonsterReleasing;
import components.entities.dynamics.characters.monster.Monster;
import components.entities.statics.bombs.Bomb;
import components.entities.statics.bombs.children.BombB;

public class Boss extends Monster {

    private Bomb bomb;

    public Boss(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 500;
        health = 500;
        speed = 8.0f;
        damage = 10;
        width = 130;
        height = 130;

        bomb = new BombB();
        bomb.getExplosion().setTargets(new String[] { "Player", "Block", });
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        attack = new RandomBombPlacing(attack, bomb);
        attack = new RandomSuicideMonsterReleasing(attack);
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        this.upFrames.add(Asset.get("gengar").crop(25, 17, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(240, 17, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(455, 17, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(669, 17, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(18, 213, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(241, 213, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(468, 213, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(693, 213, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(43, 404, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(255, 404, 170, 141));
        this.upFrames.add(Asset.get("gengar").crop(469, 404, 170, 141));

        this.downFrames.add(Asset.get("gengar").crop(691, 568, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(471, 568, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(256, 568, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(40, 568, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(696, 764, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(472, 764, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(243, 764, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(18, 764, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(670, 956, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(456, 956, 170, 141));
        this.downFrames.add(Asset.get("gengar").crop(240, 956, 170, 141));

        this.leftFrames.add(Asset.get("gengar").crop(25, 17, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(240, 17, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(455, 17, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(669, 17, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(18, 213, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(241, 213, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(468, 213, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(693, 213, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(43, 404, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(255, 404, 170, 141));
        this.leftFrames.add(Asset.get("gengar").crop(469, 404, 170, 141));

        this.rightFrames.add(Asset.get("gengar").crop(691, 568, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(471, 568, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(256, 568, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(40, 568, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(696, 764, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(472, 764, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(243, 764, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(18, 764, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(670, 956, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(456, 956, 170, 141));
        this.rightFrames.add(Asset.get("gengar").crop(240, 956, 170, 141));

        this.standFrames.add(Asset.get("gengar").crop(25, 17, 170, 141));
    }
}
