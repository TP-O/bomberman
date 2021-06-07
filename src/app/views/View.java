package app.views;

import java.awt.Graphics;
import java.util.List;

import components.ui.Element;

public abstract class View {

    protected List<Element> elements;

    public View() {
        buildUI();
    }

    protected abstract void buildUI();

    public abstract void reset();

    public abstract void tick();

    public abstract void render(Graphics graphics);
}
