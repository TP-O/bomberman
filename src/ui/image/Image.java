package ui.image;

import core.main.Handler;
import ui.Element;

public abstract class Image extends Element
{
    public Image(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);
    }
}
