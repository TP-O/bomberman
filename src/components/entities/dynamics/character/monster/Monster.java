package components.entities.dynamics.character.monster;

import config.MonsterConfig;
import components.actions.attack.Attack;
import components.actions.attack.AttackAction;
import components.actions.attack.nonstop.PlayerAttack;
import components.actions.drop.Drop;
import components.actions.drop.DropAcction;
import components.actions.drop.nonstop.ItemDrop;
import components.actions.move.RandomMove;
import components.entities.dynamics.character.Character;

public abstract class Monster extends Character
{
    private Drop drop;

    private Attack attack;

    public Monster(float x, float y)
    {
        super();

        this.x = x;
        this.y = y;

        margin = 10;
        padding = 10;
    }

    @Override
    protected void setEntityParameters()
    {
        width = MonsterConfig.WIDTH;
        height = MonsterConfig.HEIGHT;
        health = MonsterConfig.HEALTH;
        life = MonsterConfig.HEALTH;
        speed = MonsterConfig.SPEED;
        damage = MonsterConfig.DAMAGE;
    }

    @Override
    protected void initializeActions()
    {
        super.initializeActions();

        // Set drop type
        drop = new DropAcction(this);
        drop = new ItemDrop(drop);

        // Set attack type
        attack = new AttackAction(this);
        attack = new PlayerAttack(attack);

        // Set move type
        move = new RandomMove(this);
    }

    @Override
    public void setHealth(int health)
    {
        super.setHealth(health);

        if (isDeleted()) {
            // Leave a souvenir :'(
            drop.drop();
        }
    }

    @Override
    public void tick()
    {
        super.tick();

        // Attack
        attack.attack();
    }
}
