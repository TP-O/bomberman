package ui.image;

import config.GameConfig;
import asset.Asset;
import core.main.Handler;

public class HomeBackground extends Image
{
    public HomeBackground(Handler handler, float positionX, float positionY, int xx, int yy)
    {
		super(handler, positionX, positionY, xx, yy);
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
    protected void loadInfo()
    {
        width = GameConfig.WIDTH;
        height = GameConfig.HEIGHT;
    }

    @Override
    protected void loadImages()
    {
        currentImage = Asset.bg01.crop(0, 0, 1000, 750);
    }
}
