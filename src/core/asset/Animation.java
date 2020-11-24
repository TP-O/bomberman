package core.asset;

import java.awt.image.BufferedImage;

public class Animation
{    
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames)
    {
        this.speed = speed;
        this.frames = frames;
        this.index = 0;
        this.timer = 0;
        this.lastTime = System.currentTimeMillis();
    }

    public void tick()
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed)
        {
            index++;
            timer = 0;

            if (index >= frames.length) {
                index = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame()
    {
        return frames[index];
    }
}
