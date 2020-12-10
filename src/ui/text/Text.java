package ui.text;

import core.main.Handler;
import helper.Helper;
import ui.Element;
import java.awt.Graphics;

public abstract class Text extends Element
{
    public Text(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        super(handler, positionX, positionY, xx, yy);
    }

    @Override
    protected void loadImages()
    {
        value = value.toUpperCase();
        x  -= (value.length() - 1) * width / 2;

        for(int i = 0; i < value.length(); i++) {
            images.add(Helper.loadImage("alphabet/" + value.charAt(i) + ".png"));
        }
    }

    @Override
    public void render(Graphics graphics)
    {
        for(int i = 0; i < images.size(); i++) {
            graphics.drawImage(images.get(i), x + width * i, y, width, height, null);
        }
    }
}
