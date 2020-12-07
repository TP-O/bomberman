package ui.button;

import asset.Asset;
import core.main.Handler;
import core.main.Router;

public class PlayButton extends Button
{
    public PlayButton(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);
    }

    @Override
    protected void loadSize()
    {
        width = 148;
        height = 48;
    }

    @Override
    protected void loadUIImage()
    {
        images.add(Asset.ui01.crop(47, 108, 82, 24));
        images.add(Asset.ui02.crop(80, 182, 133, 40));

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
        Router.redirect("Character");
    }
}
