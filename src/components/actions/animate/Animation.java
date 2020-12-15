package components.actions.animate;

import java.awt.image.BufferedImage;
import java.util.List;

public class Animation
{    
    private int speed, index;
    private long lastTime, timer;
    private List<BufferedImage> frames;

    public Animation(int speed, List<BufferedImage> frames)
    {
        index = 0;
        timer = 0;
        this.speed = speed;
        this.frames = frames;
        this.lastTime = System.currentTimeMillis();
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public void tick()
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed)
        {
            index++;
            timer = 0;

            if (index >= frames.size()) {
                index = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame()
    {
        return frames.get(index);
    }
}
