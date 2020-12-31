package components.entities.dynamics.character.player;

import components.actions.attack.Attack;
import components.actions.attack.AttackAction;
import components.actions.attack.controlled.ControlledBombPlacing;
import components.actions.move.KeyboardBasedMove;
import components.actions.pickup.PickUp;
import components.actions.pickup.PickUpAction;
import components.actions.pickup.nonstop.ItemPickUp;
import components.entities.dynamics.character.Character;
import components.entities.statics.bombs.Bomb;
import components.entities.statics.bombs.children.BombB;
import config.PlayerConfig;

public abstract class Player extends Character
{
    private Bomb bomb;

    private Attack attack;

    private PickUp pickUp;

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

        attack = new AttackAction(this);
        attack = new ControlledBombPlacing(attack, bomb);

        pickUp = new PickUpAction(this);
        pickUp = new ItemPickUp(pickUp);

        move = new KeyboardBasedMove(this);
    }

    @Override
    public void tick()
    {
        super.tick();

        attack.attack();

        pickUp.pickUp();
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
