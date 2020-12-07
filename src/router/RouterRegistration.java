package router;

import app.controller.CharacterSelectionController;
import app.controller.GameController;
import app.controller.MenuController;
import core.main.Handler;
import core.main.Router;

public class RouterRegistration
{   
    private Handler handler;

    public RouterRegistration(Handler handler)
    {
        this.handler = handler;
    }

    public void register()
    {
        Router.register("Menu", new MenuController(handler));
        Router.register("Game", new GameController(handler));
        Router.register("Character", new CharacterSelectionController(handler));

        redirectToDefault();
    }

    public void redirectToDefault()
    {
        Router.redirect("Menu");
    }
}
