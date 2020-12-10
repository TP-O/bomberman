package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import core.main.Handler;

import ui.Element;
import ui.button.PlayButton;
import ui.button.QuitButton;
import ui.image.HomeBackground;
import ui.text.HomeTitle;

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
        elements.add(new HomeBackground(handler, 0.5f, 0.5f, 0, 0));

        // Add butons
        elements.add(new PlayButton(handler, 0.5f, 0.5f, 0, 0));
        elements.add(new QuitButton(handler, 0.5f, 0.6f, 0, 0));

        // Add text
        elements.add(new HomeTitle(handler, 0.5f, 0.3f, 0, 0));
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
