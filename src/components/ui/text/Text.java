package components.ui.text;

import core.Handler;
import helper.Helper;
import java.awt.Graphics;

import components.ui.Element;

public abstract class Text extends Element
{
    public Text(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    public void setValue(String value)
    {
        super.setValue(value);

        loadImages();
    }

    @Override
    protected void loadImages()
    {   
        // Delete old images
        images.clear();

        // Transform to uppercase
        value = value.toUpperCase();

        for(int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != ' ') {
                images.add(Helper.loadImage("alphabet/" + value.charAt(i) + ".png"));
            }
            else {
                images.add(null);
            }
        }
    }

    @Override
    public void render(Graphics graphics)
    {
        // Calculate position x to make the text in the center
        int newX  = x - (value.length() - 1) * width / 2;

        for(int i = 0; i < images.size(); i++) {
            if (images.get(i) == null) {
                continue;
            }

            graphics.drawImage(images.get(i), newX + width * i, y, width, height, null);
        }
    }
}
