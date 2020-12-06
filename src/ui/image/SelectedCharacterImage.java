package ui.image;

import app.controller.GameController;
import core.asset.Asset;

public class SelectedCharacterImage extends Image
{
    public SelectedCharacterImage(GameController game, float positionX, float positionY, int xx, int yy)
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
        width = 475;
        height = 318;
    }

    @Override
    protected void loadUIImage()
    {
        currentImage = Asset.gokuBackground.crop(0, 0, 1920, 1080);
    }
}
