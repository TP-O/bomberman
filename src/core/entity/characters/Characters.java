package core.entity.characters;

import core.entity.Entity;
import java.awt.Graphics;
import core.game.Game;

public abstract class Characters extends Entity
{
    protected int health;

    protected float speed;

    protected Game game;

    public Characters(Game inGame, float inX, float inY, int inWidth, int inHeight, int inHealth, float inSpeed)
    {
        super(inX, inY, inWidth, inHeight);
        health = inHealth;
        speed = inSpeed;
        game = inGame;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}
