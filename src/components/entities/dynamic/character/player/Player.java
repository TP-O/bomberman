package components.entities.dynamic.character.player;

import components.actions.animate.Animation;
import components.entities.dynamic.character.Character;
import components.entities.fixed.bomb.Bomb;
import components.entities.fixed.bomb.children.BombB;
import components.actions.attack.BombAttack;
import components.actions.move.KeyboardBasedMove;
import config.PlayerConfig;
import core.Handler;

public abstract class Player extends Character
{
    private Bomb bomb;

    public Player(Handler handler, float x, float y)
    {
        super(handler);

        this.x = x;
        this.y = y;
    }

    public Bomb getBomb()
    {
        return bomb;
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
        width = PlayerConfig.WIDTH;
        height =  PlayerConfig.HEIGHT;
        speed = PlayerConfig.SPEED;
        health = PlayerConfig.HEALTH;
        maxHealth = PlayerConfig.HEALTH;

        bomb = new BombB(handler);
    }

    @Override
    protected void setMove()
    {
        move = new KeyboardBasedMove(handler, this, speed);
    }

    @Override
    protected void setAttack()
    {
        attack = new BombAttack(this, null);
    }
    
    @Override
    public void tick()
    {
        super.tick();

        if (handler.getKeyboard().attack.isPressed()) {
            attack.attack();
        }
    }
}
