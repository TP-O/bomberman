package app.controller;

import java.util.ArrayList;
import java.util.Arrays;

import app.view.*;
import core.entity.character.Character;
import core.entity.character.builder.*;
import ui.Element;
import ui.button.*;
import ui.image.*;
import ui.radio.*;

public class ViewController
{
    private GameController game;

    public ViewController(GameController game)
    {
        this.game = game;
    }

    public View menu()
    {
        ArrayList<Element> elements = new ArrayList<Element>();

        // Add background
        elements.add(new HomeBackground(game, 0.5f, 0.5f, 0, 0));

        // Add butons
        elements.add(new PlayButton(game, 0.5f, 0.5f, 0, 0));
        elements.add(new QuitButton(game, 0.5f, 0.6f, 0, 0));
      
        View view = new MenuView(game, elements);

        return view;
    }

    public View game()
    {
        // Load map
        MapController map = new MapController(game);
        map.load("map01");

        // Init character builder and controller
        CharacterBuilder playerBuilder = new PlayerBuilder();
        CharacterBuilder monsterBuilder = new MonsterBuilder();
        CharacterController character = new CharacterController();

        // Create player
        Character player = playerBuilder.type("Satoshi")
                .setGame(game)
                .setX(250)
                .setY(250)
                .build();
        
        character.createPlayer(player);

        // Create monster
        Character[] monsters = {
            monsterBuilder
                .type("AlolanPersian")
                .setGame(game)
                .setX(500)
                .setY(250)
                .build(),
            monsterBuilder
                .type("ShinyZygarde")
                .setGame(game)
                .setX(800)
                .setY(250)
                .build(),
            monsterBuilder
                .type("Scorbunny")
                .setGame(game)
                .setX(800)
                .setY(300)
                .build(),
            monsterBuilder
                .type("Bulbasaur")
                .setGame(game)
                .setX(400)
                .setY(300)
                .build(),
            monsterBuilder
                .type("Emboar")
                .setGame(game)
                .setX(400)
                .setY(500)
                .build(),
            monsterBuilder
                .type("ShinyEmboar")
                .setGame(game)
                .setX(350)
                .setY(500)
                .build(),
        };

        character.createMonsters(Arrays.asList(monsters));

        // Create bombs
        BombController bomb = new BombController();

        // Create explosions
        ExplosionController explosion = new ExplosionController();

        // Init view
        View view = new GameView(game, map.getMap(), character.getPlayer(),
                character.getMonsters(), bomb.getBombs(), explosion.getExplosions());

        return view;
    }

    public View character()
    {
        ArrayList<Element> elements = new ArrayList<Element>();

        // Add background
        elements.add(new SelectedCharacterBackground(game, 0.5f, 0.5f, 0, 0));

        // Add buttons
        elements.add(new StartButton(game, 0.5f, 0.8f, 0, 0));
        elements.add(new ReturnButton(game, 0.08f, 0.05f, 0, 0));

        // Add radios
        elements.add(new GokuRadio(game, 0.5f, 0.5f, 50, 80));
        elements.add(new KidRadio(game, 0.5f, 0.5f, -270, -240));
        elements.add(new MonkRadio(game, 0.5f, 0.5f, -270, -80));
        elements.add(new ShadowRadio(game, 0.5f, 0.5f, -270, 80));
        elements.add(new KiritoRadio(game, 0.5f, 0.5f, -110, 80));
        elements.add(new SatoshiRadio(game, 0.5f, 0.5f, 210, 80));

        // Share data
        Element image = new SelectedCharacterImage(game, 0.51f, 0.3f, 10, -10);
        elements.forEach(element -> image.shareWith(element));

        // Add image
        elements.add(image);

        View view = new CharacterView(game, elements);

        return view;
    }
}
