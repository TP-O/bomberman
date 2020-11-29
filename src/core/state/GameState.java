package core.state;

import java.awt.Graphics;
import java.util.Arrays;

import app.controller.GameController;
import app.controller.MapController;
import core.entity.character.Character;
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
        init();
    }

    public void tick()
    {
        mapController.getMap().tick();
        characterController.getCharacters().forEach(character -> character.tick());

        // make the camera record the player
        gameController.getCameraService().focusOn(characterController.getPlayer());
    }

    public void render(Graphics graphics)
    {
        mapController.getMap().render(graphics);
        characterController.getCharacters().forEach(character -> character.render(graphics));
    }

    private void init()
    {
        initMap("map01");
        initPlayer();
        initMonsters();
    }

    private void initMap(String mapName)
    {
        mapController.load(mapName);
    }

    private void initPlayer()
    {
        characterController.setPlayer(
            CharacterController.builder
                .setType("Kirito")
                .setGame(gameController)
                .setX(250)
                .setY(250)
                .build());
    }

    private void initMonsters()
    {
        Character[] monsters = {
            CharacterController.builder
                .setType("AlolanPersian")
                .setGame(gameController)
                .setX(500)
                .setY(250)
                .build(),
            CharacterController.builder
                .setType("ShinyZygarde")
                .setGame(gameController)
                .setX(800)
                .setY(250)
                .build(),
            CharacterController.builder
                .setType("Scorbunny")
                .setGame(gameController)
                .setX(800)
                .setY(300)
                .build(),
            CharacterController.builder
                .setType("Bulbasaur")
                .setGame(gameController)
                .setX(400)
                .setY(300)
                .build(),
            CharacterController.builder
                .setType("RedBoss")
                .setGame(gameController)
                .setX(400)
                .setY(500)
                .build(),
            CharacterController.builder
                .setType("BlueBoss")
                .setGame(gameController)
                .setX(350)
                .setY(500)
                .build(),
        };

        characterController.create(Arrays.asList(monsters));
    }
}
