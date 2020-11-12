package core.state;

import java.awt.Graphics;
import app.controller.GameController;

public abstract class State
{
    protected GameController gameController;

    public State(GameController gameController)
    {
        this.gameController = gameController;
    }

    public abstract void tick();
    
    public abstract void render(Graphics graphics);
}
