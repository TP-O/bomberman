package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import core.main.Handler;
import ui.Element;
import ui.button.ReturnButton;
import ui.button.StartButton;
import ui.image.SelectedCharacterBackground;
import ui.image.SelectedCharacterImage;
import ui.radio.*;

public class CharacterView extends View
{
    private ArrayList<Element> elements;

    public CharacterView(Handler handler)
    {
        this.handler = handler;

        build();
    }

    @Override
    protected void build()
    {
        elements = new ArrayList<Element>();

        // Add background
        elements.add(new SelectedCharacterBackground(handler, 0.5f, 0.5f, 0, 0));

        // Add buttons
        elements.add(new StartButton(handler, 0.5f, 0.8f, 0, 0));
        elements.add(new ReturnButton(handler, 0.08f, 0.05f, 0, 0));

        // Add radios
        elements.add(new GokuRadio(handler, 0.5f, 0.5f, 50, 80));
        elements.add(new KidRadio(handler, 0.5f, 0.5f, -270, -240));
        elements.add(new MonkRadio(handler, 0.5f, 0.5f, -270, -80));
        elements.add(new ShadowRadio(handler, 0.5f, 0.5f, -270, 80));
        elements.add(new KiritoRadio(handler, 0.5f, 0.5f, -110, 80));
        elements.add(new SatoshiRadio(handler, 0.5f, 0.5f, 210, 80));

        // Share data
        Element image = new SelectedCharacterImage(handler, 0.51f, 0.3f, 10, -10);
        elements.forEach(element -> image.shareWith(element));

        // Add image
        elements.add(image);
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
