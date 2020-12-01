package core.UI.button;

import java.awt.Graphics;

import app.controller.GameController;
import core.asset.Asset;
import core.main.Router;

public class PlayButton extends Button
{

    public PlayButton(GameController game, boolean disable)
    {
        super(game, disable);
    }

    public PlayButton(GameController game, int x, int y, int width, int height, boolean disable)
    {
        super(game, x, y, width, height, disable);
    }

    @Override
    protected void loadSize()
    {
        x = game.getWidth()/2 - 148/2;
        y = game.getHeight()/2 - 48/2 - 60;
        width = 148;
        height = 48;
    }

    @Override
    protected void loadUIImage()
    {
        BImages.add(Asset.ui01.crop(47, 108, 82, 24));
        BImages.add(Asset.ui02.crop(80, 182, 133, 40));

        currentImage = BImages.get(0);
    }

    @Override
    public void waiting()
    {
        currentImage = BImages.get(0);
    }

    @Override
    public void onHover()
    {
        currentImage = BImages.get(1);
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
