package app.view;

import java.awt.Graphics;
import app.controller.GameController;

public abstract class View
{
    protected GameController game;

    public View(GameController game)
    {
        this.game = game;
    }

    public abstract void tick();
    
    public abstract void render(Graphics graphics);
}
