package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import config.GameConfig;
import core.main.Handler;

public abstract class Element implements EventListener, Sharable
{
    protected int x, y;

    protected int width, height;

    protected Handler handler;

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

    public Element(Handler handler, float positionX, float positionY, int xx, int yy)
    {
        this.handler = handler;
        
        loadSize();
        
        // Display based on screen percentage
        x = (int) (GameConfig.WIDTH * positionX - width / 2 + xx);
        y = (int) (GameConfig.HEIGHT * positionY - height / 2 + yy);

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
        return handler.getMouse().mouseX > x
                && handler.getMouse().mouseX < x + width
                && handler.getMouse().mouseY > y
                && handler.getMouse().mouseY < y + height
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
            if (handler.getMouse().left.isPressed()) {
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
