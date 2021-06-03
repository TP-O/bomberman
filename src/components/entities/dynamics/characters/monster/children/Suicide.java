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

        this.upFrames.add(Asset.get("scorbunny").crop(12, 90, 56, 58));
        this.upFrames.add(Asset.get("scorbunny").crop(91, 90, 56, 58));

        this.downFrames.add(Asset.get("scorbunny").crop(12, 11, 56, 58));
        this.downFrames.add(Asset.get("scorbunny").crop(92, 11, 56, 58));

        this.leftFrames.add(Asset.get("scorbunny").crop(12, 172, 56, 58));
        this.leftFrames.add(Asset.get("scorbunny").crop(90, 171, 56, 58));

        this.rightFrames.add(Asset.get("scorbunny").crop(8, 250, 56, 58));
        this.rightFrames.add(Asset.get("scorbunny").crop(87, 250, 56, 58));

        this.standFrames.add(Asset.get("scorbunny").crop(12, 11, 56, 58));
    }

    @Override
    public void tick() {
        super.tick();

        this.attack.attack();
    }
}
