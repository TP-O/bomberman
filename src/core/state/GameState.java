package core.state;

import java.awt.Graphics;

import core.game.Game;
import app.controller.MapController;
import app.controller.CharacterController;

public class GameState extends State
{
    private MapController mapController;

    private CharacterController characterController;

    public GameState(Game game, CharacterController charactersController)
    {
        super(game);
        this.mapController = new MapController(game);
        this.characterController = charactersController;
        this.init();
    }

    public void init()
    {
        characterController.create(
            CharacterController.builder
                .setType("Player")
                .setGame(game)
                .setX(250)
                .setY(250)
                .build());

        mapController.load("map01");
    }

    public void tick()
    {
        characterController.getPlayer().tick();
        mapController.getMap().tick();

        // make the camera record the player
        game.getCameraService().focusOn(characterController.getPlayer());
    }

    public void render(Graphics graphics)
    {
        mapController.getMap().render(graphics);
        characterController.getPlayer().render(graphics);
    }
}
