package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.actions.attack.AttackAction;
import components.actions.attack.collision.CollisionExplosion;
import components.actions.drop.DropAcction;
import components.entities.dynamics.characters.monster.Monster;
import components.entities.statics.explosions.Explosion;
import components.entities.statics.explosions.children.ExplosionD;

public class Gengar extends Monster{
    
    private int range;

    private Explosion explosion;

    public Gengar(float x, float y) {
        super(x, y);
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        this.drop = new DropAcction(this);

        this.attack = new AttackAction(this);
        this.attack = new CollisionExplosion(this.attack, this.explosion, this.range);
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

    @Override
    public void tick() {
        super.tick();

        this.attack.attack();
    }

}
