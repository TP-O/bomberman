package components.entities.dynamic.character;

import components.actions.attack.Attack;
import components.actions.display.Display;
import components.actions.display.HealthDisplay;
import components.entities.constract.Attackable;
import components.entities.constract.Displayable;
import components.entities.dynamic.DynamicEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import core.Handler;

public abstract class Character extends DynamicEntity implements Attackable, Displayable
{
    protected int health;

    protected int maxHealth;

    protected int damage;

    protected Attack attack;

    protected List<Display> displays;

    protected boolean collied;

    protected List<BufferedImage> up, down, left, right, stand;

    public Character(Handler handler)
    {
        super(handler);

        setActions();

        loadAllFrames();
        initializeAnimation();
    }

    @Override
    public int getHealth()
    {
        return health;
    }

    @Override
    public void setHealth(int health)
    {
        this.health = health >= maxHealth ? maxHealth : health;
        
        deleted = health <= 0;
    }

    @Override
    public int getMaxHealth()
    {
        return maxHealth;
    }

    @Override
    public void setMaxHealth(int health)
    {
        this.maxHealth = health;
    }

    @Override
    public int getDamage()
    {
        return damage;
    }

    @Override
    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    @Override
    protected void setActions()
    {
        displays = new ArrayList<Display>();
        displays.add(new HealthDisplay(this));
    }

    @Override
    public void attack()
    {
        attack.attack();
    }

    @Override
    public void display(Graphics graphics)
    {
        displays.forEach(display -> display.display(graphics));
    }

    @Override
    public void tick()
    {
        super.tick();
    }

    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame,
            (int) (x - handler.getCamera().getXOffset()),
            (int) (y - handler.getCamera().getYOffset()),
            width, height, null);
        
        display(graphics);
    }
}
