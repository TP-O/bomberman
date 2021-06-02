package components.actions.display;

import java.awt.Graphics;

import components.entities.Entity;

public abstract class DisplayDecorator implements Display {

    private Display display;

    public DisplayDecorator(Display display) {
        this.display = display;
    }

    @Override
    public Entity getEntity() {
        return this.display.getEntity();
    }

    @Override
    public void display(Graphics graphics) {
        this.display.display(graphics);
        this.decorate(graphics);
    }

    protected abstract void decorate(Graphics graphics);
}
