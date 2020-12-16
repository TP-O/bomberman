package components.ui.image.menu;

import config.GameConfig;
import asset.Asset;
import components.ui.image.Image;
import core.Handler;

public class MenuBackground extends Image
{
    public MenuBackground(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
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
