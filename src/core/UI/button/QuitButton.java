package core.UI.button;

import java.awt.Graphics;

import app.controller.GameController;
import core.asset.Asset;

public class QuitButton extends Button
{

    public QuitButton(GameController game, boolean disable)
    {
        super(game, disable);
    }

    public QuitButton(GameController game, int x, int y, int width, int height, boolean disable)
    {
        super(game, x, y, width, height, disable);
    }

    @Override
    protected void loadSize()
    {
        x = game.getWidth()/2 - 158/2;
        y = game.getHeight()/2 - 48/2;
        width = 158;
        height = 48;
    }

    @Override
    protected void loadUIImage()
    {
        BImages.add(Asset.ui01.crop(145, 250, 82, 25));
        BImages.add(Asset.ui02.crop(243, 416, 132, 41));

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
        System.exit(0);
    }

    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }
}