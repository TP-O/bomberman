package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import core.main.Handler;
import ui.Element;

public class MenuView extends View
{
    private ArrayList<Element> elements;

    public MenuView(Handler handler, ArrayList<Element> elements)
    {
        this.handler = handler;
        this.elements = elements;
    }

    public void tick()
    {
        elements.forEach(element -> element.tick());
    }

    public void render(Graphics graphics)
    {
        elements.forEach(element -> element.render(graphics));
    }
}
