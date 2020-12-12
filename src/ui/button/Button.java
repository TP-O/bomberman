package ui.button;

import core.main.Handler;
import ui.Element;

public abstract class Button extends Element
{
    public Button(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    public void onWaiting()
    {
        currentImage = images.get(0);
    }

    @Override
    public void onHover()
    {
        currentImage = images.get(1);
    }
}
