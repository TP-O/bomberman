package components.entities.dynamics.character.player.children;

import asset.Asset;
import components.entities.dynamics.character.player.Player;

public class Shadow extends Player
{
    public Shadow(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life= 140;
        health = 140;
        speed = 2.8f;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.shadow.crop(77, 193, 38, 63));
        upFrames.add(Asset.shadow.crop(13, 191, 38, 63));
        upFrames.add(Asset.shadow.crop(205, 193, 38, 63));
        upFrames.add(Asset.shadow.crop(13, 191, 38, 63));

        downFrames.add(Asset.shadow.crop(77, 0, 38, 63));
        downFrames.add(Asset.shadow.crop(13, 0, 38, 63));
        downFrames.add(Asset.shadow.crop(205, 1, 38, 63));
        downFrames.add(Asset.shadow.crop(13, 0, 38, 63));

        leftFrames.add(Asset.shadow.crop(79, 65, 38, 63));
        leftFrames.add(Asset.shadow.crop(15, 65, 38, 63));
        leftFrames.add(Asset.shadow.crop(207, 67, 38, 63));
        leftFrames.add(Asset.shadow.crop(15, 65, 38, 63));
        
        rightFrames.add(Asset.shadow.crop(75, 129, 38, 63));
        rightFrames.add(Asset.shadow.crop(11, 129, 38, 63));
        rightFrames.add(Asset.shadow.crop(203, 131, 38, 63));
        rightFrames.add(Asset.shadow.crop(11, 129, 38, 63));

        standFrames.add(Asset.shadow.crop(13, 0, 38, 63));
    }
}
