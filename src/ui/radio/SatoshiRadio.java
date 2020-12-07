package ui.radio;

import asset.Asset;
import core.main.Handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import app.controller.GameController;

public class SatoshiRadio extends Radio
{
    private BufferedImage innerImage;

    private BufferedImage characterImage;

    public SatoshiRadio(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);

        value = "Satoshi";
    }

    @Override
    protected void loadSize()
    {    
        width = 100;
        height = 100;
    }

    @Override
    protected void loadUIImage()
    {
        images.add(Asset.ui03.crop(6, 50, 38, 38));
        images.add(Asset.ui03.crop(190, 50, 38, 38));
        innerImage = Asset.satoshiBackground.crop(0, 0, 603, 532);
        characterImage = Asset.satoshiAvatar.crop(0, 0, 548, 447);

        currentImage = images.get(0);
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
        super.onClick();

        GameController.characterType = value;

        currentImage = images.get(1);
        sharedElement.setCurrentImage(characterImage);
    }
        
    @Override
    public void render(Graphics graphics)
    {
        super.render(graphics);

        graphics.drawImage(innerImage, x + 7, y + 7, 86, 86, null);
    }
}
