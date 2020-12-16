package components.ui.radio.character.selection;

import java.awt.Graphics;

import core.Handler;

import java.awt.image.BufferedImage;

import app.controllers.GameController;
import components.ui.radio.Radio;

public abstract class CharacterSelectionRadio extends Radio
{
    protected BufferedImage innerImage;

    protected BufferedImage characterImage;

    public CharacterSelectionRadio(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);

        clickedId = 0;
    }

    @Override
    public void onWaiting()
    {
        currentImage = images.get(0);
    }

    @Override
    public void onHover()
    {
        currentImage = images.get(1);
    }

    @Override
    public void onClick()
    {
        clickedId = id;
        GameController.characterType = value;

        currentImage = images.get(1);
        
        sharedElements.get("character-image").setCurrentImage(characterImage);
        sharedElements.get("character-name").setValue(value);
    }

    @Override
    public void render(Graphics graphics)
    {
        super.render(graphics);

        graphics.drawImage(innerImage, x + 7, y + 7 , 86, 86, null);
    }    
}
