package core.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.GameController;

public abstract class Element
{
    protected int x, y;

    protected int width, height;

    protected GameController game;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> images;

    protected boolean disable = false;

    protected boolean clicked = false;

    public Element(GameController game, float positionX, float positionY, int xx, int yy)
    {
        loadSize();

        this.x = (int) (game.getWidth()*positionX - width/2 + xx);
        this.y = (int) (game.getHeight()*positionY - height/2 + yy);
        this.game = game;
        images = new ArrayList<BufferedImage>();

        loadUIImage();
    }

    public int getX()
    {
		return this.x;
	}

    public void setX(int x)
    {
		this.x = x;
    }
    
    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
		return this.width;
	}

    public void setWidth(int width)
    {
		this.width = width;
    }
    
    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public ArrayList<BufferedImage> getImages()
    {
        return images;
    }

    public boolean isDisable()
    {
        return disable;
    }

    public boolean isClicked()
    {
        return clicked;
    }

    protected boolean isHovering()
    {
        return game.getMouseService().mouseX > x
                && game.getMouseService().mouseX < x + width
                && game.getMouseService().mouseY > y
                && game.getMouseService().mouseY < y + height
                && !disable;
    }

    public void tick()
    {
        if (isHovering()) {
            onHover();

            if (game.getMouseService().left.isPressed()) {
                onClick();
            }
        }
        else {
            onWait();
        }
    }

    abstract protected void onWait();

    abstract protected void onHover();

    abstract protected void onClick();

    abstract protected void loadSize();

    abstract protected void loadUIImage();

    abstract public void render(Graphics graphics);
}
