package components.ui.image.character.selection;

import asset.Asset;
import components.ui.image.Image;
import core.Handler;

public class CharacterImage extends Image
{
    public CharacterImage(Handler handler, int column, int row, int left, int right, int top, int bottom)
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
        width = 475;
        height = 318;
    }

    @Override
    protected void loadImages()
    {
        currentImage = Asset.gokuBackground.crop(0, 0, 1920, 1080);
    }
}
