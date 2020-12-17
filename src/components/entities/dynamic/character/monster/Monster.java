package components.entities.dynamic.character.monster;

import config.MonsterConfig;
import core.Handler;
import components.actions.animate.Animation;
import components.entities.dynamic.character.Character;
import components.actions.attack.CollisionAttack;
import components.actions.drop.Drop;
import components.actions.drop.ItemDrop;
import components.actions.move.RandomMove;

import app.cache.PlayerCache;

public abstract class Monster extends Character
{
    protected Drop drop;

    public Monster(Handler handler, float x, float y)
    {
        super(handler);

        this.x = x;
        this.y = y;
    }

    @Override
    protected void initializeAnimation()
    {
        move.setAnimationUp(new Animation(200, up));
        move.setAnimationDown(new Animation(200, down));
        move.setAnimationLeft(new Animation(200, left));
        move.setAnimationRight(new Animation(200, right));
        move.setAnimationStand(new Animation(200, stand));
    }

    @Override
    protected void setEntityParameters()
    {
        width = MonsterConfig.WIDTH;
        height = MonsterConfig.HEIGHT;
        health = MonsterConfig.HEALTH;
        maxHealth = MonsterConfig.HEALTH;
        speed = MonsterConfig.SPEED;
        damage = MonsterConfig.DAMAGE;
    }

    @Override
    public void setHealth(int health) 
    {
        super.setHealth(health);
        
        if (isDeleted()) {
            drop();
        }
    }

    @Override
    protected void setActions()
    {
        super.setActions();

        drop = new ItemDrop(this);
        move = new RandomMove(this, speed);
        attack = new CollisionAttack(this, (new PlayerCache()).get());
    }

    @Override
    public void tick()
    {
        super.tick();

        attack();       
    }

    public void drop()
    {
        drop.drop();
    }
}
