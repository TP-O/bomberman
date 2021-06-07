package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.actions.attack.AttackAction;
import components.actions.attack.collision.CollisionExplosion;
import components.actions.drop.DropAcction;
import components.entities.dynamics.characters.monster.Monster;
import components.entities.statics.explosions.Explosion;
import components.entities.statics.explosions.children.ExplosionD;

public class Yveltal extends Monster {
    
    private int range;

    private Explosion explosion;

    public Yveltal(float x, float y) {
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
        
        this.upFrames.add(Asset.get("yveltal").crop(15, 8, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(142, 8, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(260, 8, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(384, 8, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(505, 8, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(12, 103, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(124, 103, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(246, 103, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(368, 103, 108, 94));
        this.upFrames.add(Asset.get("yveltal").crop(488, 103, 108, 94));

        this.downFrames.add(Asset.get("yveltal").crop(495, 5, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(366, 5, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(248, 5, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(126, 5, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(6, 112, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(494, 305, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(386, 305, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(265, 305, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(142, 305, 108, 94));
        this.downFrames.add(Asset.get("yveltal").crop(18, 305, 108, 94));

        this.leftFrames.add(Asset.get("yveltal").crop(15, 8, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(142, 8, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(260, 8, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(384, 8, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(505, 8, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(12, 103, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(124, 103, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(246, 103, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(368, 103, 108, 94));
        this.leftFrames.add(Asset.get("yveltal").crop(488, 103, 108, 94));

        this.rightFrames.add(Asset.get("yveltal").crop(495, 5, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(366, 5, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(248, 5, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(126, 5, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(6, 112, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(494, 305, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(386, 305, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(265, 305, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(142, 305, 108, 94));
        this.rightFrames.add(Asset.get("yveltal").crop(18, 305, 108, 94));

        this.standFrames.add(Asset.get("yveltal").crop(15, 8, 108, 94));

    }
    @Override
    public void tick() {
        super.tick();

        this.attack.attack();
    }

}
