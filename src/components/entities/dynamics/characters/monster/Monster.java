package components.entities.dynamics.characters.monster;

import config.MonsterConfig;
import components.actions.attack.Attack;
import components.actions.attack.AttackAction;
import components.actions.attack.nonstop.PlayerAttack;
import components.actions.drop.Drop;
import components.actions.drop.DropAcction;
import components.actions.drop.random.RandomItemDrop;
import components.actions.move.collision.*;
import components.actions.move.type.RandomMove;
import components.entities.dynamics.characters.Character;

public abstract class Monster extends Character {

    protected Drop drop;

    protected Attack attack;

    public Monster(float x, float y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);

        if (isDeleted()) {
            // Leave a souvenir :'(
            drop.drop();
        }
    }

    @Override
    protected void setEntityParameters() {
        margin = 10;
        padding = 10;
        width = MonsterConfig.WIDTH;
        height = MonsterConfig.HEIGHT;
        health = MonsterConfig.HEALTH;
        life = MonsterConfig.HEALTH;
        speed = MonsterConfig.SPEED;
        damage = MonsterConfig.DAMAGE;
    }

    @Override
    protected void initializeActions() {
        super.initializeActions();

        // Set drop type
        drop = new DropAcction(this);
        drop = new RandomItemDrop(drop);

        // Set attack type
        attack = new AttackAction(this);
        attack = new PlayerAttack(attack);

        // Set move type
        move = new RandomMove(move);
        move = new AvoidingSolidTile(move);
        move = new AvoidingBlock(move);
        move = new AvoidingObstacle(move);
        move = new AvoidingBomb(move);
    }

    @Override
    public void tick() {
        super.tick();

        // Attack
        attack.attack();
    }

}
