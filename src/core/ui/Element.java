package core.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.GameController;

public abstract class Element
{
    protected int x, y;

    protected int width, height;

    protected GameController gameController;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> BImages;

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

    public ArrayList<BufferedImage> getBImages()
    {
        return BImages;
    }

    public Element(GameController gameController)
    {
        this.gameController = gameController;
        this.BImages = new ArrayList<BufferedImage>();

        loadSize();
        loadUIImage();
    }

    public Element(GameController gameController, int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameController = gameController;
        this.BImages = new ArrayList<BufferedImage>();

        loadUIImage();
    }

    abstract protected void loadSize();

    abstract protected void loadUIImage();

    abstract public void tick();

    abstract public void render(Graphics graphics);
}
