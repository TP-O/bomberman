package app.views;

import java.awt.Graphics;
import java.util.ArrayList;

import components.ui.Element;
import components.ui.button.ReturnButton;
import components.ui.button.StartButton;
import components.ui.image.character.selection.*;
import components.ui.radio.character.selection.*;
import components.ui.text.character.selection.*;

public class CharacterView extends View {

    @Override
    public void buildUI() {
        elements = new ArrayList<Element>();

        // Add background
        elements.add(new CharacterBackground(6, 6, 0, 0, 0, 0));
        elements.add(new CharacterImage(6, 5, 0, 0, 0, 0));

        // Add texts
        elements.add(new CharacterSelectionTitle(2, 6, 0, 0, 0, 0));
        elements.add(new CharacterName(10, 6, 0, 0, 0, 0));

        // Add buttons
        elements.add(new StartButton(6, 10, 0, 0, 0, 0));
        elements.add(new ReturnButton(1, 1, 0, 0, 0, 0));

        // Add radios
        elements.add(new GokuRadio(4, 3, 0, 0, 0, 0));
        elements.add(new KidRadio(4, 5, 0, 0, 0, 0));
        elements.add(new MonkRadio(4, 7, 0, 0, 0, 0));
        elements.add(new ShadowRadio(8, 3, 0, 0, 0, 0));
        elements.add(new KiritoRadio(8, 5, 0, 0, 0, 0));
        elements.add(new SatoshiRadio(8, 7, 0, 0, 0, 0));

        // Share data
        elements.forEach(element -> {
            elements.get(1).shareWith("character-image", element);
            elements.get(3).shareWith("character-name", element);
        });
    }

    @Override
    public void reset() {
        //
    }

    @Override
    public void tick() {
        elements.forEach(button -> button.tick());

    }

    @Override
    public void render(Graphics graphics) {
        elements.forEach(button -> button.render(graphics));
    }
}
