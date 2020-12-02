package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import app.controller.GameController;
import core.UI.button.Button;

public class CharacterView extends View
{
    private ArrayList<Button> characterselects;

    public CharacterView(GameController game, ArrayList<Button> characterselects)
    {
        super(game);
        this.characterselects = characterselects;
    }

    public void tick()
    {
        characterselects.forEach(button -> button.tick());

    }    

    public void render(Graphics graphics)
    {
        characterselects.forEach(button -> button.render(graphics));
        
    }
}
