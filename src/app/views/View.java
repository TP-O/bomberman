package app.views;

import java.awt.Graphics;

public abstract class View
{
    public View()
    {
        buildUI();
    }

    protected abstract void buildUI();

    public abstract void tick();
    
    public abstract void render(Graphics graphics);
}
