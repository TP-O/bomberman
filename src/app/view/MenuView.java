package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import core.main.Handler;

import ui.Element;
import ui.button.PlayButton;
import ui.button.QuitButton;
import ui.image.menu.MenuBackground;
import ui.text.menu.MenuTitle;

public class MenuView extends View
{
    private ArrayList<Element> elements;

    public MenuView(Handler handler)
    {
        this.handler = handler;

        build();
    }

    @Override
    protected void build()
    {
        elements = new ArrayList<Element>();

        // Add background
        elements.add(new MenuBackground(handler, 6, 6, 0, 0, 0, 0));

        // Add butons
        elements.add(new PlayButton(handler, 6, 6, 0, 0, 0, 0));
        elements.add(new QuitButton(handler, 6, 7, 0, 0, 0, 0));

        // Add text
        elements.add(new MenuTitle(handler, 6, 3, 0, 0, 0, 0));
    }

    @Override
    public void tick()
    {
        elements.forEach(element -> element.tick());
    }

    @Override
    public void render(Graphics graphics)
    {
        elements.forEach(element -> element.render(graphics));
    }
}
