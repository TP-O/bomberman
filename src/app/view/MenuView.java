package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import app.controller.GameController;
import core.UI.button.Button;

public class MenuView extends View
{
    private ArrayList<Button> buttons;

    public MenuView(GameController game, ArrayList<Button> buttons)
    {
        super(game);
        this.buttons = buttons;
    }

    public void tick()
    {
        buttons.forEach(button -> button.tick());
    }

    public void render(Graphics graphics)
    {
        buttons.forEach(button -> button.render(graphics));
    }
}
