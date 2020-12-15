package app.views;

import java.awt.Graphics;
import java.util.ArrayList;

import core.Handler;

import components.ui.Element;
import components.ui.button.PlayButton;
import components.ui.button.QuitButton;
import components.ui.image.menu.MenuBackground;
import components.ui.text.menu.MenuTitle;

public class MenuView implements View
{
    private Handler handler;

    private ArrayList<Element> elements;

    public MenuView(Handler handler)
    {
        this.handler = handler;

        build();
    }

    @Override
    public void build()
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
