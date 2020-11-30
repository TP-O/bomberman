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
        x = game.getWidth()/2 - 166/2;
        y = game.getHeight()/2 - 52/2 + 80;
        width = 166;
        height = 70;
    }

    @Override
    protected void loadUIImage()
    {
        BImages.add(Asset.ui.crop(148, 1452, 528, 332));
        BImages.add(Asset.ui.crop(1204, 1448, 528, 332));

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
