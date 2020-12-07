package ui.button;

import core.main.Handler;
import ui.Element;

public abstract class Button extends Element
{
    public Button(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);
    }
}
