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

    public GameState(GameController gameController, CharacterController charactersController)
    {
        super(gameController);
        this.mapController = new MapController(gameController);
        init();
    }

    public void tick()
    {
        mapController.getMap().tick();
        CharacterController.getPlayer().tick();
        CharacterController.getMonsters().forEach(monster -> monster.tick());

        // make the camera record the player
        gameController.getCameraService().focusOn(CharacterController.getPlayer());
    }

    public void render(Graphics graphics)
    {
        mapController.getMap().render(graphics);
        CharacterController.getPlayer().render(graphics);
        CharacterController.getMonsters().forEach(monster -> monster.render(graphics));
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
        CharacterController.setPlayer(
            CharacterController.builder
                .setType("Goku")
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

        CharacterController.setMonsters(Arrays.asList(monsters));
    }
}
