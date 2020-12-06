package ui.image;

import app.controller.GameController;
import ui.Element;

public abstract class Image extends Element
{
    public Image(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
    }
}
