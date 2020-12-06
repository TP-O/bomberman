package ui.button;

import app.controller.GameController;

import core.asset.Asset;
import core.main.Router;

public class ReturnButton extends Button
{
    public ReturnButton(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
    }

    @Override
    protected void loadSize()
    {
        width = 148;
        height = 38;
    }

    @Override
    protected void loadUIImage()
    {
        images.add(Asset.ui01.crop(47, 249, 81, 25));
        images.add(Asset.ui02.crop(81, 417, 132, 40));

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
        Router.redirect("Menu");
    }
}
