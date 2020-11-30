package core.UI.button;

import app.controller.GameController;
import core.UI.Element;

public abstract class Button extends Element
{

    protected boolean disable;

    public Button(GameController game, boolean disable)
    {
        super(game);
        this.disable = disable;
    }

    public Button(GameController game, int x, int y, int width, int height, boolean disable)
    {
        super(game, x, y, width, height);
        this.disable = disable;
    }

    public boolean isDisable()
    {
        return disable;
    }

    public void tick()
    {
        if (game.getMouseService().mouseX > x
            && game.getMouseService().mouseX < x + width
            && game.getMouseService().mouseY > y
            && game.getMouseService().mouseY < y + height
            && !disable
        ) {
            onHover();

            if (game.getMouseService().left.isPressed()) {
                onClick();
            }
        }
        else {
            waiting();
        }
    }

    abstract public void waiting();

    abstract public void onHover();

    abstract public void onClick();
}
