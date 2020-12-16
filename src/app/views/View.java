package app.views;

import java.awt.Graphics;

public interface View
{
    public void build();

    public void tick();
    
    public void render(Graphics graphics);
}
