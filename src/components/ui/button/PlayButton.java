package components.ui.button;

import asset.Asset;
import core.Handler;
import core.Router;

public class PlayButton extends Button
{
    public PlayButton(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    protected void loadInfo()
    {
        width = 148;
        height = 48;
    }

    @Override
    protected void loadImages()
    {
        images.add(Asset.ui01.crop(47, 108, 82, 24));
        images.add(Asset.ui02.crop(80, 182, 133, 40));

        currentImage = images.get(0);
    }

    @Override
    public void onClick()
    {
        Router.redirect("Character");
    }
}
