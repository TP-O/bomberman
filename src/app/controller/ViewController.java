package app.controller;

import java.util.ArrayList;
import java.util.Arrays;

import app.view.*;
import core.UI.button.*;
import core.entity.character.Character;
import core.entity.character.builder.*;

public class ViewController
{
    private GameController game;

    public ViewController(GameController game)
    {
        this.game = game;
    }

    public View menu()
    {
        ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(new PlayButton(game, false));
        buttons.add(new CharacterSelectionButton(game, false));
        buttons.add(new QuitButton(game, false));

        View view = new MenuView(game, buttons);

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
        View view = new CharacterView(game);

        return view;
    }
}
