package core.UI.button.CharactersButtons;

import core.UI.button.Button;

import app.controller.GameController;
import core.asset.Asset;
import java.awt.Graphics;

public class MonkSelection extends Button
{
    
    public MonkSelection(GameController game, boolean disable)
    {
        super(game,disable);
    }

    public MonkSelection(GameController game, int x, int y, int width, int height, boolean disable)
    {
        super(game, x, y, width, height, disable);
    }
    
    @Override
    protected void loadSize()
    {
        x = game.getWidth()/2 - 100/2 - 270;
        y = game.getHeight()/2 - 48/2 - 80;
        width = 100;
        height = 100;
    }

    @Override
    protected void loadUIImage()
    {
        BImages.add(Asset.ui03.crop(6, 50, 38, 38));
        BImages.add(Asset.ui03.crop(190, 50, 38, 38));

        currentImage = BImages.get(0);
    }

    @Override
    public void waiting()
    {
        currentImage = BImages.get(0);
    }
            
    @Override
    public void onHover()
    {
        currentImage = BImages.get(1);
    }

    @Override
    public void onClick()
    {
        currentImage = BImages.get(1);
    }
 
    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }
}




