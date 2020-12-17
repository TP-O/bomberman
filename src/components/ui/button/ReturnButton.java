package components.ui.button;

import asset.Asset;
import core.Handler;
import core.Router;

public class ReturnButton extends Button
{
    public ReturnButton(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    protected void loadInfo()
    {
        width = 148;
        height = 38;
    }

    @Override
    protected void loadImages()
    {
        images.add(Asset.ui01.crop(47, 249, 81, 25));
        images.add(Asset.ui02.crop(81, 417, 132, 40));

        currentImage = images.get(0);
    }

    @Override
    public void onClick()
    {
        Router.redirect("Menu");
    }
}
