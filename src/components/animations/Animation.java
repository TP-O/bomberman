package components.animations;

import java.awt.image.BufferedImage;
import java.util.List;

public abstract class Animation {

    private int speed;

    private int index;

    private long timer;

    private long lastTime;

    protected List<BufferedImage> frames;

    public Animation(int speed) {
        this.index = 0;
        this.timer = 0;
        this.lastTime = System.currentTimeMillis();
        this.speed = speed;
    }

    public int getIndex() {
        return index;
    }

    public void resetIndex() {
        index = 0;
    }

    public void setFrames(List<BufferedImage> frames) {
        this.frames = frames;

        resetIndex();
    }

    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed)
        {
            index++;
            timer = 0;

            if (index >= frames.size()) {
                resetIndex();
            }
        }
    }
}
