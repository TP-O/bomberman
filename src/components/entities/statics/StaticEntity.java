package components.entities.statics;

import components.animations.StaticAnimation;
import components.entities.Entity;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

public abstract class StaticEntity extends Entity {

    protected StaticAnimation animation;

    protected List<BufferedImage> frames;

    @Override
    protected void initializeActions() {
        // Set animation
        animation = new StaticAnimation(this, 150);
    }

    @Override
    protected void loadAllFrames() {
        // Create an empty frame list
        frames = new ArrayList<BufferedImage>();
    }

    @Override
    public void tick() {
        animation.tick();
    }

    public List<BufferedImage> getFrames() {
        return frames;
    }

    public void setFrames(List<BufferedImage> frames) {
        this.frames = frames;
    }
}
