package core.UI.radio;

import app.controller.GameController;
import core.UI.Element;

public abstract class Radio extends Element
{
    protected int id;

    protected static int total = 0;

    protected static int clickedId = -1;

    public Radio(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
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
