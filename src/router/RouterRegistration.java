package router;

import app.controllers.CharacterController;
import app.controllers.GameController;
import app.controllers.MenuController;
import core.Handler;
import core.Router;

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
        Router.register("Character", new CharacterController(handler));

        redirectToDefault();
    }

    public void redirectToDefault()
    {
        Router.redirect("Game");
    }
}
