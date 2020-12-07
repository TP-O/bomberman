package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import core.main.Handler;
import ui.Element;

public class CharacterView extends View
{
    private ArrayList<Element> elements;

    public CharacterView(Handler handler, ArrayList<Element> elements)
    {
        this.handler = handler;
        this.elements = elements;
    }

    public void tick()
    {
        elements.forEach(button -> button.tick());

    }    

    public void render(Graphics graphics)
    {
        elements.forEach(button -> button.render(graphics));      
        
    }
}
