package components.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.ui.constracts.*;
import config.GameConfig;
import core.Handler;

public abstract class Element implements Listenable, Sharable
{
    protected int x;

    protected int y;

    protected int width;

    protected int height;

    protected String value;

    protected Handler handler;

    protected BufferedImage currentImage;

    protected List<BufferedImage> images;

    protected boolean disable = false;

    protected boolean hovering = false;

    protected boolean clicked = false;

    protected Map<String, Element> sharedElements;

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public void setCurrentImage(BufferedImage image)
    {
        currentImage = image;
    }

    public Element(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        this.handler = handler;

        images = new ArrayList<BufferedImage>();
        sharedElements = new HashMap<String, Element>();

        loadInfo();
        calculatePosition(column, row, left, right, top, bottom);
        loadImages();
    }

    private void calculatePosition(int column, int row, int left, int right, int top, int bottom)
    {
        // Divide screen into 12 columns and rows
        x = GameConfig.WIDTH / 12 * column
                + GameConfig.WIDTH / 100 * left
                - GameConfig.WIDTH / 100 * right
                - width / 2;
        y = GameConfig.HEIGHT / 12 * row
                + GameConfig.HEIGHT / 100 * top
                - GameConfig.HEIGHT / 100 * bottom
                - height / 2;
    }

    @Override
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
                && !isDisable();
    }

    @Override
    public Element getSharedElement(String name)
    {
        return sharedElements.get(name);
    }

    @Override
    public void receive(String name, Element element)
    {
        sharedElements.put(name, element);
    }

    @Override
    public void shareWith(String name, Element element)
    {
        element.receive(name, this);
    }

    public void tick()
    {
        if (isHovering()) {
            if (handler.getMouse().left.isPressed() && !isClicked()) {
                clicked = true;
                onClick();
            }
            else if (!hovering) {
                hovering = true;
                onHover();
            }
        }
        else {
            clicked = false;
            hovering = false;
            onWaiting();
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, x, y, width, height, null);
    }

    abstract protected void loadInfo();

    abstract protected void loadImages();
}
