package core.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.GameController;

public abstract class Element implements EventListener, Sharable
{
    protected int x, y;

    protected int width, height;

    protected GameController game;

    protected BufferedImage currentImage;

    protected Element sharedElement;

    protected ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

    protected boolean disable = false;

    protected boolean clicked = false;

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

    public void setCurrentImage(BufferedImage image)
    {
        currentImage = image;
    }

    public Element(GameController game, float positionX, float positionY, int xx, int yy)
    {
        this.game = game;
        
        loadSize();
        
        // Display based on screen percentage
        x = (int) (game.getWidth()*positionX - width/2 + xx);
        y = (int) (game.getHeight()*positionY - height/2 + yy);

        loadUIImage();
    }

    public boolean isDisable()
    {
        return disable;
    }

    @Override
    public boolean isClicked()
    {
        return clicked;
    }

    @Override
    public boolean isHovering()
    {
        return game.getMouseService().mouseX > x
                && game.getMouseService().mouseX < x + width
                && game.getMouseService().mouseY > y
                && game.getMouseService().mouseY < y + height
                && !disable;
    }

    @Override
    public Element getSharedElement()
    {
        return sharedElement;
    }

    @Override
    public void receiveElement(Element element)
    {
        sharedElement = element;
    }

    @Override
    public void shareWith(Element element)
    {
        element.receiveElement(this);
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
            onWaiting();
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }

    abstract protected void loadSize();

    abstract protected void loadUIImage();
}
