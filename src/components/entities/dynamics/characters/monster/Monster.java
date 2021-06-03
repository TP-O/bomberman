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

public abstract class Monster extends Character
{
    protected Drop drop;

    protected Attack attack;

    public Monster(float x, float y)
    {
        super();

        this.x = x;
        this.y = y;
        this.margin = 10;
        this.padding = 10;
    }

    @Override
    public void setHealth(int health)
    {
        super.setHealth(health);

        if (isDeleted()) {
            // Leave a souvenir :'(
            this.drop.drop();
        }
    }

    @Override
    protected void setEntityParameters()
    {
        this.width = MonsterConfig.WIDTH;
        this.height = MonsterConfig.HEIGHT;
        this.health = MonsterConfig.HEALTH;
        this.life = MonsterConfig.HEALTH;
        this.speed = MonsterConfig.SPEED;
        this.damage = MonsterConfig.DAMAGE;
    }

    @Override
    protected void initializeActions()
    {
        super.initializeActions();

        // Set drop type
        this.drop = new DropAcction(this);
        this.drop = new RandomItemDrop(drop);

        // Set attack type
        this.attack = new AttackAction(this);
        this.attack = new PlayerAttack(attack);

        // Set move type
        this.move = new RandomMove(move);
        this.move = new AvoidingSolidTile(move);
        this.move = new AvoidingBlock(move);
        this.move = new AvoidingObstacle(move);
        this.move = new AvoidingBomb(move);
    }

    @Override
    public void tick()
    {
        super.tick();

        // Attack
        this.attack.attack();
    }

}
