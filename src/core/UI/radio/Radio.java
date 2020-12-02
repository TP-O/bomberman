package core.UI.radio;

import app.controller.GameController;
import core.UI.Element;

public abstract class Radio extends Element
{
    public Radio(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
    }
}
