package components.entities.dynamics.character.monster;

import config.MonsterConfig;
import components.behaviors.attack.PlayerCollisionAttack;
import components.behaviors.drop.DropBehavior;
import components.behaviors.drop.ItemDrop;
import components.behaviors.move.RandomMove;
import components.entities.dynamics.character.Character;

public abstract class Monster extends Character
{
    protected DropBehavior drop;

    public Monster(float x, float y)
    {
        super();

        this.x = x;
        this.y = y;

        margin = 5;
        padding = 0;
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
        drop = new ItemDrop(this);

        // Set attack type
        attack = new PlayerCollisionAttack(this);

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
