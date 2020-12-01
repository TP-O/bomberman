package core.UI.button.CharactersButtons;

import core.UI.button.Button;

import app.controller.GameController;

import core.asset.Asset;
import core.main.Router;


import java.awt.Graphics;



public class StartButton extends Button
{
    
    public StartButton(GameController game, boolean disable)
    {
        super(game, disable);
    }

    public StartButton(GameController game, int x, int y, int width, int height, boolean disable)
    {
        super(game, x, y, width, height, disable);
    }

    @Override
    protected void loadSize()
    {
        x = game.getWidth()/2 - 158/2;
        y = game.getHeight()/2 - 48/2 + 230;
        width = 158;
        height = 48;
    }

    @Override
    protected void loadUIImage()
    {
        BImages.add(Asset.ui01.crop(48, 73, 80, 25));
        BImages.add(Asset.ui02.crop(80, 123, 132, 39));

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
        Router.redirect("Game");
    }

    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }
}
