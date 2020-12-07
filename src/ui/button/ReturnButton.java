package ui.button;

import asset.Asset;
import core.main.Handler;
import core.main.Router;

public class ReturnButton extends Button
{
    public ReturnButton(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);
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
