package core.state;

import java.awt.Graphics;
import core.game.Game;

public abstract class State
{
    protected Game game;

    public State(Game inGame)
    {
        game = inGame;
    }

    public abstract void tick();
    
    public abstract void render(Graphics graphics);
}
