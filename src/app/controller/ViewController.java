package app.controller;

import java.util.ArrayList;
import java.util.Arrays;

import app.view.*;
import core.UI.Element;
import core.UI.button.*;
import core.UI.image.HomeBackground;
import core.UI.image.SelectedCharacterBackground;
import core.UI.image.SelectedCharacterImage;
import core.UI.radio.*;
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
        ArrayList<Element> elements = new ArrayList<Element>();

        // Add background
        elements.add(new HomeBackground(game, 0, 0, 702, 320));

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
        ArrayList<Element> elements = new ArrayList<Element>();

        // Add background
        elements.add(new SelectedCharacterBackground(game, 0, 0, 702, 320));

        // Add buttons
        elements.add(new StartButton(game, 0.5f, 0.5f, 0, 230));
        elements.add(new ReturnButton(game, 0.5f, 0.5f, -635, -285));

        // Add radios
        elements.add(new KidRadio(game, 0.5f, 0.5f, -270, -240));
        elements.add(new MonkRadio(game, 0.5f, 0.5f, -270, -80));
        elements.add(new ShadowRadio(game, 0.5f, 0.5f, -270, 80));
        elements.add(new KiritoRadio(game, 0.5f, 0.5f, -110, 80));
        elements.add(new GokuRadio(game, 0.5f, 0.5f, 50, 80));
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
