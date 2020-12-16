package components.ui.button;

import asset.Asset;
import core.Handler;
import core.Router;

public class StartButton extends Button
{
    public StartButton(Handler handler, int column, int row, int left, int right, int top, int bottom)
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
        images.add(Asset.ui01.crop(48, 73, 80, 25));
        images.add(Asset.ui02.crop(80, 123, 132, 39));

        currentImage = images.get(0);
    }

    @Override
    public void onClick()
    {
        Router.redirect("Game");
    }
}
