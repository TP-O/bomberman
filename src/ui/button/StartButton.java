package ui.button;

import asset.Asset;
import core.main.Handler;
import core.main.Router;

public class StartButton extends Button
{
    public StartButton(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);
    }

    @Override
    protected void loadSize()
    {
        width = 158;
        height = 48;
    }

    @Override
    protected void loadUIImage()
    {
        images.add(Asset.ui01.crop(48, 73, 80, 25));
        images.add(Asset.ui02.crop(80, 123, 132, 39));

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
        Router.redirect("Game");
    }
}
