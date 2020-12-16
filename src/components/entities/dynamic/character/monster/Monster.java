package components.entities.dynamic.character.monster;

import config.MonsterConfig;
import core.Handler;
import components.actions.animate.Animation;
import components.entities.dynamic.character.Character;
import components.actions.attack.CollisionAttack;
import components.actions.move.RandomMove;
import app.cache.PlayerCache;

public abstract class Monster extends Character
{
    public Monster(Handler handler, float x, float y)
    {
        super(handler);

        this.x = x;
        this.y = y;

        deleted = false;
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
        speed = MonsterConfig.SPEED;
        damage = MonsterConfig.DAMAGE;
    }

    @Override
    protected void setMove()
    {
        move = new RandomMove(handler, this, speed);
    }

    @Override
    protected void setAttack()
    {
        attack = new CollisionAttack(this, (new PlayerCache()).get());
    }

    @Override
    public void tick()
    {
        super.tick();

        attack();
    }
}
