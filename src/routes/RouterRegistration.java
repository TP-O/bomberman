package routes;

import core.Router;

public class RouterRegistration
{
    private Router router;

    public RouterRegistration()
    {
        router = Router.getInstance();
    }

    public void register()
    {
        router.register("Menu", "MenuController@showHomeMenu");
        router.register("PauseMenu", "MenuController@showPauseMenu");
        router.register("Game", "GameController@playSolo");
        router.register("Character", "CharacterController@selectCharacter");

        redirectToDefault();
    }

    public void redirectToDefault()
    {
        router.redirect("Game", true);
    }
}
