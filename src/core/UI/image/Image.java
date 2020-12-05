package core.UI.image;

import app.controller.GameController;
import core.UI.Element;

public abstract class Image extends Element
{
    public Image(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
    }
}
