package components.ui.text.menu;

import components.ui.text.Text;
import core.Handler;

public class MenuTitle extends Text
{
    public MenuTitle(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    public void onHover()
    {
        //
    }

    @Override
    public void onClick()
    {
        //
    }

    @Override
    public void onWaiting()
    {
        //
    }

    @Override
    protected void loadInfo()
    {
        width = 64;
        height = 64;
        value = "Boom Hello";
    }
}
