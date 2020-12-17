package components.entities.statics;

import components.entities.Entity;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

public abstract class StaticEntity extends Entity
{
    protected List<BufferedImage> frames;

    @Override
    protected void loadAllFrames()
    {
        // Create an empty frame list
        frames = new ArrayList<BufferedImage>();
    }
}
