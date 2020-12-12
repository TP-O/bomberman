package ui.radio;

import core.main.Handler;
import ui.Element;

public abstract class Radio extends Element
{
    protected int id;

    protected static int total = 0;

    protected static int clickedId = -1;

    public Radio(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);

        id = total++;
    }
}
