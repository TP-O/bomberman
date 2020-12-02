package core.UI.radio;

import app.controller.GameController;
import core.asset.Asset;
import java.awt.Graphics;

public class MonkRadio extends Radio
{
    public MonkRadio(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
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
        super.onClick();
        currentImage = images.get(1);
    }
 
    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }
}
