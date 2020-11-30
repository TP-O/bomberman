package app.controller;

import java.util.ArrayList;
import java.util.Arrays;

import app.view.*;
import core.UI.button.*;
import core.entity.character.Character;
import core.entity.character.CharacterBuilder;

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
        CharacterBuilder characterBuilder = new CharacterBuilder();
        CharacterController character = new CharacterController();

        // Create player
        Character player = characterBuilder.setType("Goku")
                .setGame(game)
                .setX(250)
                .setY(250)
                .build();
        
        character.setPlayer(player);

        // Create monster
        Character[] monsters = {
            characterBuilder
                .setType("AlolanPersian")
                .setGame(game)
                .setX(500)
                .setY(250)
                .build(),
            characterBuilder
                .setType("ShinyZygarde")
                .setGame(game)
                .setX(800)
                .setY(250)
                .build(),
            characterBuilder
                .setType("Scorbunny")
                .setGame(game)
                .setX(800)
                .setY(300)
                .build(),
            characterBuilder
                .setType("Bulbasaur")
                .setGame(game)
                .setX(400)
                .setY(300)
                .build(),
            characterBuilder
                .setType("RedBoss")
                .setGame(game)
                .setX(400)
                .setY(500)
                .build(),
            characterBuilder
                .setType("BlueBoss")
                .setGame(game)
                .setX(350)
                .setY(500)
                .build(),
        };

        character.setMonsters(Arrays.asList(monsters));

        // Init view
        View view = new GameView(game, map.getMap(), character.getPlayer(), character.getMonsters());

        return view;
    }

    public View character()
    {
        View view = new CharacterView(game);

        return view;
    }
}
