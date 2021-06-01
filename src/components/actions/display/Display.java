package components.actions.display;

import java.awt.Graphics;

import components.entities.Entity;

public interface Display {
    public Entity getEntity();

    public void display(Graphics graphics);
}
