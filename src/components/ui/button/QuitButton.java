package components.ui.button;

import asset.Asset;
import core.Handler;

public class QuitButton extends Button
{
    public QuitButton(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    protected void loadInfo()
    {
        width = 158;
        height = 48;
    }

    @Override
    protected void loadImages()
    {
        images.add(Asset.ui01.crop(145, 250, 82, 25));
        images.add(Asset.ui02.crop(243, 416, 132, 41));

        currentImage = images.get(0);
    }

    @Override
    public void onClick()
    {
        System.exit(0);
    }
}
