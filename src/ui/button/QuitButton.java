package ui.button;

import asset.Asset;
import core.main.Handler;

public class QuitButton extends Button
{
    public QuitButton(Handler handler, float positionX, float positionY, int xx, int yy)
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
        images.add(Asset.ui01.crop(145, 250, 82, 25));
        images.add(Asset.ui02.crop(243, 416, 132, 41));

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
        System.exit(0);
    }
}
