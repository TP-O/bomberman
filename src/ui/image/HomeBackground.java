package ui.image;

import app.controller.GameController;
import core.asset.Asset;

public class HomeBackground extends Image
{
    public HomeBackground(GameController game, float positionX, float positionY, int xx, int yy)
    {
		super(game, positionX, positionY, xx, yy);
	}

	@Override
    public void onHover()
    {
        //
    }

    @Override
    public void onClick()
    {
        //
    }

    @Override
    public void onWaiting()
    {
        //
    }

    @Override
    protected void loadSize()
    {
        width = game.getWidth();
        height = game.getHeight();
    }

    @Override
    protected void loadUIImage()
    {
        currentImage = Asset.bg01.crop(0, 0, 1000, 750);
    }
}
