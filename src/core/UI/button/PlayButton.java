package core.UI.button;

import java.awt.Graphics;

import app.controller.GameController;
import core.asset.Asset;
import core.main.Router;

public class PlayButton extends Button
{
    public PlayButton(GameController game, float positionX, float positionY, int xx, int yy)
    {
        super(game, positionX, positionY, xx, yy);
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
    public void onWait()
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

    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }
}
