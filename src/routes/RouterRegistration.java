package routes;

import core.Router;

public class RouterRegistration {

    private Router router;

    public RouterRegistration() {
        this.router = Router.getInstance();
    }

    public void register() {
        this.router.register("Menu", "MenuController@showHomeMenu");
        this.router.register("PauseMenu", "MenuController@showPauseMenu");
        this.router.register("GameOverMenu", "MenuController@showGameOverMenu");
        this.router.register("Game", "GameController@playSolo");
        this.router.register("Character", "CharacterController@selectCharacter");

        redirectToDefault();
    }

    public void redirectToDefault() {
        this.router.redirect("Menu", true);
    }
}
