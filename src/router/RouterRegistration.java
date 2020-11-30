package router;

import app.controller.GameController;
import app.controller.ViewController;
import core.main.Router;

public class RouterRegistration
{
    private ViewController view;

    public RouterRegistration(GameController game)
    {
        view = new ViewController(game);
    }

    public void register()
    {
        Router.register("Menu", view.menu());
        Router.register("Game", view.game());
        Router.register("Character", view.character());

        redirectToDefault();
    }

    public void redirectToDefault()
    {
        Router.redirect("Game");
    }
}
