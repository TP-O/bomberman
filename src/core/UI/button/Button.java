package core.UI.button;

import app.controller.GameController;
import core.UI.Element;
import java.awt.Graphics;

public abstract class Button extends Element
{
    public Button(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
    }
}
