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
        return this.index;
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setFrames(List<BufferedImage> frames) {
        this.frames = frames;

        this.resetIndex();
    }

    public void tick() {
        this.timer += System.currentTimeMillis() - this.lastTime;
        this.lastTime = System.currentTimeMillis();

        if (this.timer > this.speed)
        {
            this.index++;
            this.timer = 0;

            if (this.index >= this.frames.size()) {
                resetIndex();
            }
        }
    }
}
