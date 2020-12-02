package core.UI.radio;

import java.awt.Graphics;

import app.controller.GameController;
import core.asset.Asset;


import core.UI.button.Button;

public class GokuRadio extends Button
{
    public GokuRadio(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
    }
    
    @Override
    protected void loadSize()
    {
        x = game.getWidth()/2 - 100/2 + 50;
        y = game.getHeight()/2 - 48/2 + 80;
        width = 100;
        height = 100;
    }

    @Override
    protected void loadUIImage()
    {
        images.add(Asset.ui03.crop(6, 50, 38, 38));
        images.add(Asset.ui03.crop(190, 50, 38, 38));

        currentImage = images.get(0);
    }

    @Override
    public void onWait()
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
        currentImage = images.get(1);
    }
        
    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }
}
