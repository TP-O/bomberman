package app.view;

import java.awt.Graphics;

import core.main.Handler;

public abstract class View
{
    protected Handler handler;

    protected abstract void build();

    public abstract void tick();
    
    public abstract void render(Graphics graphics);
}
