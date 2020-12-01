package core.UI.button.CharactersButtons;

import core.UI.button.Button;

import app.controller.GameController;

import core.asset.Asset;
import core.main.Router;
import java.awt.Graphics;

public class ReturnButton extends Button
{
    
    public ReturnButton(GameController game, boolean disable)
    {
        super(game, disable);
    }

    public ReturnButton(GameController game, int x, int y, int width, int height, boolean disable)
    {
        super(game, x, y, width, height, disable);
    }

    @Override
    protected void loadSize()
    {
        x = game.getWidth()/2 - 148/2 - 635;
        y = game.getHeight()/2 - 48/2 - 285;
        width = 148;
        height = 38;
    }

    @Override
    protected void loadUIImage()
    {
        BImages.add(Asset.ui01.crop(47, 249, 81, 25));
        BImages.add(Asset.ui02.crop(81, 417, 132, 40));

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
        Router.redirect("Menu");
    }

    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }
}
