package components.entities.dynamics.character.player;

import components.behaviors.attack.BombPlacingAttack;
import components.behaviors.move.KeyboardBasedMove;
import components.behaviors.pickup.ItemPickUp;
import components.behaviors.pickup.PickUpBehavior;
import components.entities.dynamics.character.Character;
import components.entities.statics.bombs.Bomb;
import components.entities.statics.bombs.children.BombB;
import config.PlayerConfig;

public abstract class Player extends Character
{
    private Bomb bomb;

    private PickUpBehavior pickup;

    public Player(float x, float y)
    {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected void setEntityParameters()
    {
        width = PlayerConfig.WIDTH;
        height =  PlayerConfig.HEIGHT;
        speed = PlayerConfig.SPEED;
        health = PlayerConfig.HEALTH;
        life = PlayerConfig.HEALTH;

        bomb = new BombB();
    }

    @Override
    protected void initializeActions()
    {
        super.initializeActions();

        // Set pick-up type
        pickup = new ItemPickUp(this);

        // Set attack type
        attack = new BombPlacingAttack(this, bomb);

        // Set move type
        move = new KeyboardBasedMove(this);
    }
    
    @Override
    public void tick()
    {
        super.tick();

        // Pick-up items :D
        pickup.pickUp();

        if (handler.getKeyboard().attack.isPressed()) {
            // Attack
            long now = System.currentTimeMillis();

            if (now - attackedAt >= 500 || attackedAt == 0) {
                attack.attack();

                attackedAt = now;
            }
        }
    }

    public Bomb getBomb()
    {
        return bomb;
    }

    public void setBomb(Bomb bomb)
    {
        this.bomb = bomb;
    }
}
