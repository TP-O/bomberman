package components.entities.dynamics.characters.monster.children;

import app.cache.EntityCache;
import asset.Asset;
import components.actions.attack.AttackAction;
import components.actions.attack.collision.CollisionExplosion;
import components.actions.drop.DropAcction;
import components.actions.move.MoveAction;
import components.actions.move.collision.*;
import components.actions.move.type.Follow;
import components.entities.dynamics.characters.Character;
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

        life = 9999;
        health = 9999;
        range = 2;
        speed = 4.0f;
        explosion = new ExplosionD();
        explosion.setTargets(new String[] { "Player", "Block", });
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        drop = new DropAcction(this);

        move = new MoveAction(this);
        move = new AvoidingSolidTile(move);
        move = new AvoidingBlock(move);
        move = new AvoidingObstacle(move);
        move = new AvoidingBomb(move);
        move = new Follow(move, (Character) EntityCache.get("player").get(0));

        attack = new AttackAction(this);
        attack = new CollisionExplosion(attack, explosion, range);

    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("scorbunny").crop(12, 90, 56, 58));
        upFrames.add(Asset.get("scorbunny").crop(91, 90, 56, 58));

        downFrames.add(Asset.get("scorbunny").crop(12, 11, 56, 58));
        downFrames.add(Asset.get("scorbunny").crop(92, 11, 56, 58));

        leftFrames.add(Asset.get("scorbunny").crop(12, 172, 56, 58));
        leftFrames.add(Asset.get("scorbunny").crop(90, 171, 56, 58));

        rightFrames.add(Asset.get("scorbunny").crop(8, 250, 56, 58));
        rightFrames.add(Asset.get("scorbunny").crop(87, 250, 56, 58));

        standFrames.add(Asset.get("scorbunny").crop(12, 11, 56, 58));
    }

    @Override
    public void tick() {
        super.tick();

        attack.attack();
    }
}
