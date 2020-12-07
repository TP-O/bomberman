package ui.radio;

import core.main.Handler;
import ui.Element;

public abstract class Radio extends Element
{
    protected int id;

    protected String value;

    protected static int total = 0;

    protected static int clickedId = -1;

    public Radio(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);
        
        id = total++;       
    }

    @Override
    public void onClick()
    {
        clickedId = id;
    }

    @Override
    public void tick()
    {
        if (clickedId != -1 && clickedId == id) {
            onClick();       
        }
        else {
            super.tick();
        }
    }
}
