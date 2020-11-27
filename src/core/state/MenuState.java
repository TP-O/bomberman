package core.state;

import java.awt.Graphics;
import java.util.ArrayList;

import app.controller.GameController;
import core.ui.button.*;

public class MenuState extends State
{
    private ArrayList<Button> buttons;

    public MenuState(GameController gameController)
    {
        super(gameController);

        buttons = new ArrayList<Button>();
        buttons.add(new PlayButton(gameController, false));
        buttons.add(new CharacterSelectionButton(gameController, false));
        buttons.add(new QuitButton(gameController, false));
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
