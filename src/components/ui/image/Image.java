package components.ui.image;

import components.ui.Element;
import core.Handler;

public abstract class Image extends Element
{
    public Image(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }
}
