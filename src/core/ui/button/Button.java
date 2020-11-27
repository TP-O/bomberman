package core.ui.button;

import app.controller.GameController;
import core.ui.Element;

public abstract class Button extends Element
{

    protected boolean disable;

    public Button(GameController gameController, boolean disable)
    {
        super(gameController);
        this.disable = disable;
    }

    public Button(GameController gameController, int x, int y, int width, int height, boolean disable)
    {
        super(gameController, x, y, width, height);
        this.disable = disable;
    }

    public boolean isDisable()
    {
        return disable;
    }

    public void tick()
    {
        if (gameController.getMouseService().mouseX > x
            && gameController.getMouseService().mouseX < x + width
            && gameController.getMouseService().mouseY > y
            && gameController.getMouseService().mouseY < y + height
            && !disable
        ) {
            onHover();

            if (gameController.getMouseService().left.isPressed()) {
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
