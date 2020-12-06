package ui.button;

import app.controller.GameController;
import ui.Element;

public abstract class Button extends Element
{
    public Button(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
    }
}
