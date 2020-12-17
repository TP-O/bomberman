package components.entities.dynamic.character.player;

import components.actions.animate.Animation;
import components.entities.constract.Greed;
import components.entities.dynamic.character.Character;
import components.entities.fixed.bomb.Bomb;
import components.entities.fixed.bomb.children.BombB;
import components.actions.attack.BombAttack;
import components.actions.move.KeyboardBasedMove;
import components.actions.pickup.ItemPickUp;
import components.actions.pickup.Pickup;
import config.PlayerConfig;
import core.Handler;

public abstract class Player extends Character implements Greed
{
    private Bomb bomb;

    private Pickup pickup;

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
    protected void setActions()
    {
        super.setActions();

        pickup = new ItemPickUp(this);
        attack = new BombAttack(this);
        move = new KeyboardBasedMove(this, speed);
    }

    @Override
    public void pickUp()
    {
        pickup.pick();
    }
    
    @Override
    public void tick()
    {
        super.tick();

        pickUp();

        if (handler.getKeyboard().attack.isPressed()) {
            attack.attack();
        }
    }
}
