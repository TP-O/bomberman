package app.views;

import java.awt.Graphics;
import java.util.ArrayList;

import core.Handler;
import components.ui.Element;
import components.ui.button.ReturnButton;
import components.ui.button.StartButton;
import components.ui.image.character.selection.*;
import components.ui.radio.character.selection.*;
import components.ui.text.character.selection.*;

public class CharacterView implements View
{
    private Handler handler;

    private ArrayList<Element> elements;

    public CharacterView(Handler handler)
    {
        this.handler = handler;

        build();
    }

    @Override
    public void build()
    {
        elements = new ArrayList<Element>();

        // Add background
        elements.add(new CharacterBackground(handler, 6, 6, 0, 0, 0, 0));
        elements.add(new CharacterImage(handler, 6, 5, 0, 0, 0, 0));

        // Add texts
        elements.add(new CharacterSelectionTitle(handler, 2, 6, 0, 0, 0, 0));
        elements.add(new CharacterName(handler, 10, 6, 0, 0, 0, 0));

        // Add buttons
        elements.add(new StartButton(handler, 6, 10, 0, 0, 0, 0));
        elements.add(new ReturnButton(handler, 1, 1, 0, 0, 0, 0));

        // Add radios
        elements.add(new GokuRadio(handler, 4, 3, 0, 0, 0, 0));
        elements.add(new KidRadio(handler, 4, 5, 0, 0, 0, 0));
        elements.add(new MonkRadio(handler, 4, 7, 0, 0, 0, 0));
        elements.add(new ShadowRadio(handler, 8, 3, 0, 0, 0, 0));
        elements.add(new KiritoRadio(handler, 8, 5, 0, 0, 0, 0));
        elements.add(new SatoshiRadio(handler, 8, 7, 0, 0, 0, 0));

        // Share data
        elements.forEach(element -> {
            elements.get(1).shareWith("character-image", element);
            elements.get(3).shareWith("character-name", element);
        });
    }

    @Override
    public void tick()
    {
        elements.forEach(button -> button.tick());

    }    

    @Override
    public void render(Graphics graphics)
    {
        elements.forEach(button -> button.render(graphics));      
    }
}
