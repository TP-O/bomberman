package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.actions.attack.AttackAction;
import components.actions.attack.collision.CollisionExplosion;
import components.actions.drop.DropAcction;
import components.entities.dynamics.characters.monster.Monster;
import components.entities.statics.explosions.Explosion;
import components.entities.statics.explosions.children.ExplosionD;

public class Suicide extends Monster {

    private int range;

    private Explosion explosion;

    public Suicide(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        this.life = 9999;
        this.health = 9999;
        this.range = 2;
        this.speed = 4.0f;
        this.explosion = new ExplosionD();
        this.explosion.setTargets(new String[] { "Player", "Block", });
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        this.drop = new DropAcction(this);

        this.attack = new AttackAction(this);
        this.attack = new CollisionExplosion(this.attack, this.explosion, this.range);
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        
        this.upFrames.add(Asset.get("suicide").crop(911, 18, 61, 61));
        this.upFrames.add(Asset.get("suicide").crop(784, 18, 61, 61));
        this.upFrames.add(Asset.get("suicide").crop(657, 18, 61, 61));
        this.upFrames.add(Asset.get("suicide").crop(527, 18, 61, 61));
        this.upFrames.add(Asset.get("suicide").crop(400, 18, 61, 61));
        this.upFrames.add(Asset.get("suicide").crop(278, 18, 61, 61));
        this.upFrames.add(Asset.get("suicide").crop(154, 18, 61, 61));
        this.upFrames.add(Asset.get("suicide").crop(28, 18, 61, 61));

        this.downFrames.add(Asset.get("suicide").crop(31, 143, 61, 61));
        this.downFrames.add(Asset.get("suicide").crop(158, 143, 61, 61));
        this.downFrames.add(Asset.get("suicide").crop(286, 143, 61, 61));
        this.downFrames.add(Asset.get("suicide").crop(414, 143, 61, 61));
        this.downFrames.add(Asset.get("suicide").crop(543, 143, 61, 61));
        this.downFrames.add(Asset.get("suicide").crop(663, 143, 61, 61));
        this.downFrames.add(Asset.get("suicide").crop(787, 143, 61, 61));
        this.downFrames.add(Asset.get("suicide").crop(914, 143, 61, 61));

        this.leftFrames.add(Asset.get("suicide").crop(911, 18, 61, 61));
        this.leftFrames.add(Asset.get("suicide").crop(784, 18, 61, 61));
        this.leftFrames.add(Asset.get("suicide").crop(657, 18, 61, 61));
        this.leftFrames.add(Asset.get("suicide").crop(527, 18, 61, 61));
        this.leftFrames.add(Asset.get("suicide").crop(400, 18, 61, 61));
        this.leftFrames.add(Asset.get("suicide").crop(278, 18, 61, 61));
        this.leftFrames.add(Asset.get("suicide").crop(154, 18, 61, 61));
        this.leftFrames.add(Asset.get("suicide").crop(28, 18, 61, 61));

        this.rightFrames.add(Asset.get("suicide").crop(31, 143, 61, 61));
        this.rightFrames.add(Asset.get("suicide").crop(158, 143, 61, 61));
        this.rightFrames.add(Asset.get("suicide").crop(286, 143, 61, 61));
        this.rightFrames.add(Asset.get("suicide").crop(414, 143, 61, 61));
        this.rightFrames.add(Asset.get("suicide").crop(543, 143, 61, 61));
        this.rightFrames.add(Asset.get("suicide").crop(663, 143, 61, 61));
        this.rightFrames.add(Asset.get("suicide").crop(787, 143, 61, 61));
        this.rightFrames.add(Asset.get("suicide").crop(914, 143, 61, 61));

        this.standFrames.add(Asset.get("suicide").crop(914, 143, 61, 61));

    }

    @Override
    public void tick() {
        super.tick();

        this.attack.attack();
    }

}
