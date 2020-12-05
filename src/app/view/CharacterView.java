package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import app.controller.GameController;
import core.UI.Element;

public class CharacterView extends View
{
    private ArrayList<Element> elements;

    public CharacterView(GameController game, ArrayList<Element> elements)
    {
        super(game);
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
