package core.state;

import java.awt.Graphics;

import app.controller.GameController;
import app.controller.MapController;
import app.controller.CharacterController;

public class GameState extends State
{
    private MapController mapController;

    private CharacterController characterController;

    public GameState(GameController gameController, CharacterController charactersController)
    {
        super(gameController);
        this.mapController = new MapController(gameController);
        this.characterController = charactersController;
        this.init();
    }

    public void init()
    {
        characterController.create(
            CharacterController.builder
                .setType("Kirito")
                .setGame(gameController)
                .setX(250)
                .setY(250)
                .build());
        
        characterController.create(
            CharacterController.builder
                .setType("AlolanPersian")
                .setGame(gameController)
                .setX(500)
                .setY(250)
                .build());
        
        characterController.create(
            CharacterController.builder
                .setType("ShinyZygarde")
                .setGame(gameController)
                .setX(800)
                .setY(250)
                .build());

        characterController.create(
            CharacterController.builder
                .setType("Scorbunny")
                .setGame(gameController)
                .setX(800)
                .setY(300)
                .build());
        
        characterController.create(
            CharacterController.builder
                .setType("Bulbasaur")
                .setGame(gameController)
                .setX(400)
                .setY(300)
                .build());
        
        characterController.create(
            CharacterController.builder
                .setType("RedBoss")
                .setGame(gameController)
                .setX(400)
                .setY(500)
                .build());

        characterController.create(
            CharacterController.builder
                .setType("BlueBoss")
                .setGame(gameController)
                .setX(350)
                .setY(500)
                .build());
        
        mapController.load("map01");
    }

    public void tick()
    {
        mapController.getMap().tick();
        characterController.getPlayer().tick();
        characterController.getCharacters().get(1).tick();
        characterController.getCharacters().get(2).tick();
        characterController.getCharacters().get(3).tick();
        characterController.getCharacters().get(4).tick();
        characterController.getCharacters().get(5).tick();
        characterController.getCharacters().get(6).tick();

        // make the camera record the player
        gameController.getCameraService().focusOn(characterController.getPlayer());
    }

    public void render(Graphics graphics)
    {
        mapController.getMap().render(graphics);
        characterController.getPlayer().render(graphics);
        characterController.getCharacters().get(1).render(graphics);
        characterController.getCharacters().get(2).render(graphics);
        characterController.getCharacters().get(3).render(graphics);
        characterController.getCharacters().get(4).render(graphics);
        characterController.getCharacters().get(5).render(graphics);
        characterController.getCharacters().get(6).render(graphics);
    }
}
