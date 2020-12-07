package ui.image;

import config.GameConfig;
import asset.Asset;
import core.main.Handler;

public class SelectedCharacterBackground extends Image
{
    public SelectedCharacterBackground(Handler handler, float positionX, float positionY, int xx, int yy)
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
    protected void loadSize()
    {
        width = GameConfig.WIDTH;
        height = GameConfig.HEIGHT;
    }

    @Override
    protected void loadUIImage()
    {
        currentImage = Asset.bg02.crop(0, 0, 1000, 760);
    }
}
