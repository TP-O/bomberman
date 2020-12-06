package app.view;

import java.awt.Graphics;
import java.util.ArrayList;
import app.controller.GameController;
import ui.Element;

public class MenuView extends View
{
    private ArrayList<Element> elements;

    public MenuView(GameController game, ArrayList<Element> elements)
    {
        super(game);

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
