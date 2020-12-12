package ui.image;

import core.main.Handler;
import ui.Element;

public abstract class Image extends Element
{
    public Image(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }
}
